object session {
  def abs(x: Double) = if(x < 0) -x else x

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    def isGoodEnough(guess: Double, x: Double): Boolean =
      abs(guess * guess - x) < 0.0001 * x

    def improve(guess: Double, x: Double): Double =
      (guess + x / guess) / 2

    sqrtIter(1.0, x)
  }

  sqrt(2)
  sqrt(4)
  sqrt(1e-6)
  sqrt(1e60)

  sqrt(0.001)
  sqrt(0.1e-20)
  sqrt(1.0e20)
  sqrt(1.0e50)
}