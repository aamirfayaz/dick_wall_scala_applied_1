object Test1 extends App {
  def add(x: Int, y: Int) {
    x + y
  }
  val res: Unit = add(3,4)
  println(res)
}

object Test2 extends App {
  /**
   *  while, do-while are the only build in control flow constructs that only return Unit.
   */
  private val initCode = new scala.collection.mutable.ListBuffer[() => Unit]

  def delayExecution(body: => Unit) = {
      initCode += (() => body)
    }
  val res:Unit = Thread.sleep(6000)
  delayExecution(res)

  for (proc <- initCode) proc()

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

object TestCallByName extends App {
  val x:Int = 10
}