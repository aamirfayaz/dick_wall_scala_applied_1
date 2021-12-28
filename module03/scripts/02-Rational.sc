class Rational(val n: Int, val d: Int) {
  require(d != 0, "Zero denominator!")

  override def toString: String = s"R($n/$d)"

  def min(other: Rational): Rational =
    if ((n.toDouble / d) < (other.n.toDouble / other.d))
      this else other

  def +(other: Rational): Rational =
    new Rational(
      this.n * other.d + this.d * other.n,
      this.d * other.d
    )

  // we can't put return type annotation here
  def this(i: Int) = this(i, 1)
}

val half = new Rational(1, 2)
val fifth = new Rational(1, 5)

val smaller = fifth min half

val sum = half + fifth

val intRational = new Rational(3)
val sum2 = half + intRational

val divByZero = new Rational(1, 0)