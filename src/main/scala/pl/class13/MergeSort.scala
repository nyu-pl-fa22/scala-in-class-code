package class13

import akka.actor.{Actor, ActorSystem, Props}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration.Duration

class MergeSort(l: List[Int], p: Promise[List[Int]]) extends Actor:
  val root = context.actorOf(Props(new Sorter))

  l.foreach { root ! Some(_) }
  root ! None

  def collectResult(result: List[Int]): Receive = {
    case Some(x:Int) => 
      context.become(collectResult(x :: result))
    case None => 
      p.success(result)
  }

  def receive = collectResult(Nil)

object Sorting extends App:
   
  val input = List(1, 5, 3, 2) //args.foldRight(Nil: List[Int]) { _.toInt :: _ }
  println(s"Input: $input")

  val system = ActorSystem("MergeSort")
  val p = Promise[List[Int]]
  val m = system.actorOf(Props(new MergeSort(input, p)))
  
  // create future that processes result
  val t = for {
    output <- p.future // get result from promise
    _ <- system.terminate() // terminate actor system
  } yield println(s"Output: $output")
        
  Await.ready(t, Duration.Inf)
