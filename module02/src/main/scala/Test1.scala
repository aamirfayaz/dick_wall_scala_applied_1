object Test1 extends App {
  def add(x: Int, y: Int) {
    x + y
  }
  val res: Unit = add(3,4)
  println(res)
}

object Test2 extends App {
/**
  while, do-while are the only build in control flow constructs that only return Unit.
 */
  var l = 1
  while(l < 5) {
    print(l + " ")
    l = l + 1
  }
  println("----")
  l = 1
  do {
    print(l + " ")
    l = l + 1
  } while(l < 5)
}