// Arrays are Mutable:

val arr = Array("scooby", "dooby", "doo")

arr(0) = "scrappy"
arr(1) = "dappy"

arr.mkString(" ")
new Array[String](10) // java way
// Lists and Vectors are not mutable

val xs1 = List(1,2,3)
val xs2 = 0 :: xs1

var xs3 = List(4,5,6)
xs3 = xs2 ::: xs3  // because it's a var

// Sets may be either:

import scala.collection._

val s1: mutable.Set[Int] = mutable.Set(1,2,3) //val and mutable
var s2: Predef.Set[Int] = immutable.Set(1,2,3) //var and immutable

// += on both types:

s1 += 4  // calls += on mutable.Set
s1
//rewriting rule kicks-in
s2 += 4  // turns into s2 = s2 + 4 // not possible if s2 is val
s2

// Maps also may be either

val m1 = mutable.Map('a' -> 1, 'b' -> 2, 'c' -> 3)

var m2 = immutable.Map('d' -> 4, 'e' -> 5, 'f' -> 6)

m1 ++= m2 // calls ++= on mutable map, hence result map is mutable
m1
println("--111-------")
m2 += 'g' -> 7 //equivalent to m2 = m2 + ('g' -> 7)
m2
println("--222---")
m1 += 'g' -> 7 // += method on mutable Map

val map = mutable.Map("a" -> 1)
map("a") = 12
map("aa") = 14 //key not found, so add this element to map
map
val map2 = Map("x" -> 1)
//map2("x") = 11 CTE, no update method in immutable Map
