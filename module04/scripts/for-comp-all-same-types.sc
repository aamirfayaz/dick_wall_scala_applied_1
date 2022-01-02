import scala.concurrent.ExecutionContext.Implicits.global

val t = scala.util.Try(10)
val f = scala.concurrent.Future(10)
/**
 * <-, all generators in the same for block,
 * must be of the same type (e.g. a collection, Future, or a Try)
 * applies only to generators
 */

for {
  tt <- t
  x = f // fine with assignment
  if x.isCompleted // fine with guard too
  // x <- f CTE, it must be Try container
} yield tt

for {
  tt <- t
    x = f // fine with assignment
  // x <- f CTE, it must be Try container
} yield scala.concurrent.Future(10) // fine with give too

for {
  tt <- f
  // x <- t// CTE, it must be Future container
} yield tt

