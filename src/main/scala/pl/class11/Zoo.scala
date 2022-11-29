abstract class Animal {
 def makeNoise: Unit
}

class Cat extends Animal {
  override def makeNoise = println("Meow!")
}

class Dog extends Animal {
  override def makeNoise = println("Woof!")
}

class Lion extends Animal {
  override def makeNoise = println("Roar!")
}


class Animals[A <: Animal](private val animals: List[A]) {
  def makeNoise: Unit = for (a <- animals) a.makeNoise
}

object Zoo extends App {
  val dogs: Animals[Dog] = new Animals(List(new Dog()))
  
  val cats: Animals[Cat] = new Animals(List(new Cat()))
  
  val zoo: Animals[Animal] = new Animals(List(new Dog(), new Cat(), new Lion()))
  
  zoo.makeNoise
}