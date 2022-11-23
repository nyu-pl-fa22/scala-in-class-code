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

trait Duck:
  def quack(): Unit

  def push(): Unit = quack()

trait Flyable:
  def fly(): Unit

class Mallard extends Duck with Flyable:
  override def quack(): Unit = println("Quack!")

  override def fly(): Unit = println("Heading south!")

  override def push(): Unit =
    quack()
    fly()


class RubberDuck extends Duck:
  override def quack(): Unit = println("Squeak!")

trait Coffee:
  val basePrice: Double

  def price: Double = basePrice

  override def toString: String = "coffee"

trait Milk extends Coffee:
  override def price: Double = super.price + 0.5

  override def toString: String = super.toString + " with milk"

trait Sugar extends Coffee:
  override def toString: String = super.toString + " with sugar"

val c: Coffee = new Coffee with Sugar with Milk { val basePrice = 4.0 }

println(s"A ${c.toString} costs $$${c.price}.")