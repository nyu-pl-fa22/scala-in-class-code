{
  var x = 3

  def foo() = {
    println(x)
  }

  {
    //println(x)
    var x = 5
    foo()
  }
}