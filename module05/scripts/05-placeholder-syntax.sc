val nums: List[Int] = (1 to 10).toList

nums.filter(_ < 4)
nums.span(_ % 4 != 0)
nums.partition(_ % 4 != 0)

// will not compile, as the param can't be used twice
// nums.map(_ * _)
// have to use
nums.map(x => x * x)
//nums.map(_ *_) // no as x * x, x is used twice
// instead

def compareNeighbors(xs: List[Int], compare: (Int, Int) => Int): List[Int] = {
  for (pair <- xs.sliding(2)) yield {
    compare(pair(0), pair(1))
  }
}.toList

compareNeighbors(nums, _ + _)

def compareNeighbors2[A](xs: List[A], compare: (A, A) => A): List[A] = {
  for (pair <- xs.sliding(2)) yield {
    compare(pair(0), pair(1))
  }
}.toList
//compareNeighbors2(nums, _ + _), CTE not able to infer
def compareNeighbors3[A](xs: List[A])(compare: (A, A) => A): List[A] = {
  for (pair <- xs.sliding(2)) yield {
    compare(pair(0), pair(1))
  }
}.toList
compareNeighbors3(nums)(_ + _)



// will not compile, _s in ()s mean something else
// compareNeighbors(List(4, 1, 7, 3, 4, 8), (_ - _).abs)

compareNeighbors(nums, _ + _)  // can infer types
compareNeighbors(nums, (_: Int) + (_: Int))  // explicit types
compareNeighbors(nums, (x,y) => x + y)  // can infer types

//val addPair2 = _ + _ //unable to infer types
val addPair = (_: Int) + (_: Int)
val addPair2: (Int, Int) => Int = _ + _ //can infer from type annotations
val addPair3:(Int, Int) => Int = (x, y) => x + y
compareNeighbors(nums, addPair)

val addPair2 = (a: Int, b: Int) => a + b
compareNeighbors(nums, addPair2)
