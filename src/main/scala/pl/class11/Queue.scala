class Queue[@specialized(Int) +A] (private[this] val queue: List[A]) {
  
  def enqueue[B >: A](x: B): Queue[B] = {
    new Queue[B](queue :+ x)
  }

  def head: A = {
    require(!isEmpty, "Queue.head on empty queue")
    queue.last
  }
  
  def dequeue: (A, Queue[A]) = {
    require(!isEmpty, "Queue.dequeue on empty queue")
    val x :: queue1 = queue
    (x, new Queue(queue1))
  }

  def isEmpty: Boolean = queue.isEmpty

  override def toString: String = {
    s"Queue${queue.toString.drop(4)}"
  }
}

object Queue {
  def empty[A]: Queue[A] = new Queue(Nil)

  def apply[A](xs: A*): Queue[A] = new Queue(xs.toList)
}

object QueueTest extends App {
  val q: Queue[Int] = Queue.empty
  
  val q1 = q.enqueue(1).enqueue(2).enqueue(3).enqueue(4)
  
  val qAny: Queue[Any] = q1
  
  println(qAny.enqueue("Hello"))
  
  println(q1.dequeue._2.dequeue)
  println(q1)
}
