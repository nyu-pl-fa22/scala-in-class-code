object PointObj {
  val first = 1.0
  val second = 2.0
}

class Point(val first: Double, val second: Double) {
  def print(): Unit = {
    println("Point(" + this.first + ", " + this.second + ")")
  }

  def plus(that: Point): Point = {
    that.print()
    new Point(this.first + that.first,
              this.second + that.second)
  }
}

class ColorPoint(fst: Double, snd: Double, val color: Int)
  extends Point(fst, snd) {
  override def print(): Unit = {
    println("ColorPoint(" + this.first + ", " +
                        this.second +
                        "," + this.color + ")")
  }
}


var p = new Point(1.0, 2.0)
var q = new Point(3.0, 4.0)

val cp = new ColorPoint(3.0, 3.0, 10)

val pcp = p.plus(cp)
