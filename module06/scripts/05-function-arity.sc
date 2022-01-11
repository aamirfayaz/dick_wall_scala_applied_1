//Functions have an Arity, which means the number of input parameters
//limits to 22
val sq: Int => Int = x => x * x  // Function1[Int, Int]
val add: (Int, Int) => Int = (a, b) => a + b  // Function2[Int, Int, Int]
val mult3: (Int, Int, Int) => Int = _ * _ * _ // Function3[Int, Int, Int, Int]


import scala.util.Random
val makeARandom: () => Double = () => Random.nextDouble()
val makeARandom2: Function0[Double] = new Function0[Double] {
  override def apply() = Random.nextDouble()
}

makeARandom()
makeARandom()
