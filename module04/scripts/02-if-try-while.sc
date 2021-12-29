import scala.annotation.tailrec

val args = Array.empty[String] // ("myfile.txt")

val fileName = if (args.length > 0) args(0) else "default.txt"

val x = -10

val res = if (x > 0) x else false


val fileName2 =
  try {
    args.head
  }
  catch {
    case _: NoSuchElementException => "default.txt"
  }
  finally {
    println("Wheeeee")
    "the finally block"
  }

def greetStatement(n: Int): Unit = {
  var i = 0
  while(i < n) {
    i +=1
    println("hello")
  }
}
greetStatement(6)
@tailrec
def greet(n: Int, curr: Int = 0): Unit = {
  if (curr < n) {
    println("Hello")
    greet(n, curr + 1)
  } else ()
}

/**
  Scala does tail call optimization for us.
  It convert tail recursive function into while loop
  as above.
 */
greet(5)

  //without =, so default return type is Unit
def greet2(n: Int, curr: Int = 0)  {
  if (curr < n) {
    println("Hello")
    greet(n, curr + 1)
  } else ()
}
greet2(2)
