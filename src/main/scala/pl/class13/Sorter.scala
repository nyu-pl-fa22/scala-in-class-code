package class13

import akka.actor.{Actor, ActorRef, Props, Stash}

class Sorter extends Actor with Stash {

  def receive = start(None)

  def start(m: Option[Int]): Receive = 
    case None =>
      m foreach { context.parent ! Some(_) }
      context.parent ! None
      context.stop(self)
    case Some(x: Int) =>
      m match
        case None =>
          context.become(start(Some(x)))
        case Some(y) =>
          val child1 = context.actorOf(Props[Sorter]())
          val child2 = context.actorOf(Props[Sorter]())
          child1 ! Some(x)
          child2 ! Some(y)
          context.become(split(child1, child2))
      

  def split(child1: ActorRef, child2: ActorRef): Receive = {
    case None =>
      child1 ! None
      child2 ! None
      context.become(merge(None, self))
    case Some(x: Int) =>
      child1 ! Some(x)
      context.become(split(child2, child1))
  }

  def merge(m: Option[Int], prevSender: ActorRef): Receive = {
    m match {
      case None => {
        case None => context.become(copy)
        case Some(x: Int) =>
          context.become(merge(Some(x), sender()))
      }
      case Some(y: Int) => {
        case None =>
          if (sender() == prevSender) {
            stash()
          } else {
            context.parent ! Some(y)
            unstashAll()
            context.become(copy)
          }
        case Some(x: Int) =>
          if (sender() == prevSender) {
            stash()
          } else if (x > y) {
            context.parent ! Some(x)
          } else {
            context.parent ! Some(y)
            unstashAll()
            context.become(merge(Some(x), sender()))
          }
      }
    }
  }

  def copy: Receive = {
    case None =>
      context.parent ! None
      context.stop(self)
    case Some(x: Int) =>
      context.parent ! Some(x)
  }

}

