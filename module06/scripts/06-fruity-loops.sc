import scala.annotation.tailrec


@tailrec
def fruitLoop(pred: () => Boolean)(body: () => Unit): Unit = {
  if (pred()) {
    body()
    fruitLoop(pred)(body)
  }
}

var x = 0

fruitLoop(() => x < 5) { () =>
  println(x * x)
  x += 1
}


@tailrec
def fruityLoop(pred: => Boolean)(body: => Unit): Unit = {
  if (pred) {
    body
    fruityLoop(pred)(body)
  }
}

var y = 0

//this now looks like a while loop, so call-by-name trick for Function0
//By-names are easy to get wrong, beware! Convert to Function0 ASAP
fruityLoop(y < 5) {
  println(y * y)
  y += 1
}
//change fruityLoop to while, it runs the same way
while(y < 5) {
  println(y * y)
  y += 1
}

// an experiment
def printPredicate(f: Function0[Boolean]) = println(f())
/**
 * The reason its called, call-by-name because we can
 * invoke it by name only, no need of parenthesis

 */
def lp(pred: => Boolean)(body: => Unit): Unit = {
  //printPredicate(pred) //CTE
  printPredicate(() => pred)
  if (pred) {
    body
    fruityLoop(pred)(body)
  }
}

lp(y < 5) {
  println(y * y)
  y += 1
}

