// Using call-by-name parameters to implement short-circuiting
def and(x: Boolean, y: => Boolean): Boolean =
  if x then y else false

val s: String = null
and(s != null, s.endsWith("foo"))

def outer(i: Int, f: () => Unit): Unit = {
  def inner(): Unit = println(i)

  if (i > 1) f()
  else outer(2, inner)
}

def foo(): Unit = ()

// What does the following call print?
outer(1, foo)
