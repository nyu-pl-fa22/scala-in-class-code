var x = 3
var y = 4

x = if x > 5 && y < 3 then
  x + 1
else
  x - 1

val c = 'X'

x = x + 1

x = c match
  case 'X' => 10
  case 'V' => 5
  case 'I' => 1
  case _ => -1
  
while x < 10 do
  y = y + y
  x = x + 1
  
def max(x: Int, y: Int): Int = 
  if x < y then y else x
  
max(2, 3)

  
var x = 0

def set_x(v: Int): Unit =
  x = v

def foo(s: Int => Unit, y: Int): () => Unit = 
  var x = 0
  
  def print_x(): Unit = println(x)

  s(y)
  print_x()
  print_x


val p = foo(set_x, 1)
set_x(2)
p()

def foo(): String = {
  val f = {x: Int => return "Hello"; 3}
  f(3); "World"
}

foo()
