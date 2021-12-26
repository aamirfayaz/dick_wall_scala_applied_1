def max(x: Int, y: Int): Int =
  if (x > y) x else y

def min(x: Int, y: Int) =
  if (x < y) x else y

def sayHi(name: String): Unit = {
  println(s"hello $name")
}

val r:Unit = sayHi("Scala class")
r

def procedureSyntax(name: String) {
  println(s"hello $name")
}

def add(x: Int, y: Int)  {
  x + y
}
val res: Unit = add(3,4)
res



