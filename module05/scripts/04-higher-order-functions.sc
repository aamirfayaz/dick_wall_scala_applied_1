val nums = (1 to 10).toList

nums.map(x => x * x)
nums.filter(x => x < 4)
nums.span(x => x % 4 != 0) //till cond. is true put in one list rest other
nums.span(_ % 2 == 0)
nums.span(_ < 5)
nums.partition(x => x % 4 != 0)


def compareNeighbors(xs: List[Int], compare: (Int, Int) => Int): List[Int] = {
  for (pair <- xs.sliding(2)) yield {
    compare(pair(0), pair(1))
  }
}.toList

compareNeighbors(nums, (a, b) => a + b) //a,b infer type Int from nums

compareNeighbors(List(4, 1,7,  3, 4, 8), (a, b) => (a - b).abs)

def compareNeighbors2(xs: List[Int], compare: Function2[Int, Int, Int]): List[Int] = {
  for (pair <- xs.sliding(2)) yield {
    compare(pair(0), pair(1))
  }
}.toList