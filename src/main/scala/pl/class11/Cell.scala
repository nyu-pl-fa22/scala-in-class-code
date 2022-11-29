class Cell[A](private var content: A) {
  def read: A = content
  
 def write(x: A): Unit = {
    content = x
 }
}

object CellTest extends App {
  val c = new Cell("Hello")
  
  // val c1: Cell[AnyRef] = c // Rejected because Cell[String] is not a subtype of Cell[AnyRef]
  
  // c1.write(new AnyRef) // would break c's invariant that it stores a String
  
  c.read.charAt(0)
}
