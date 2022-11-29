object ScalaArray {
  val ss = Array[String]("hello")
  
  //val os: Array[AnyRef] = ss // rejected by the type checker because Array[String] is not a subtype of Array[AnyRef]
  
  //os(0) = new AnyRef()
  
  ss(0).charAt(0)
}
