import scala.annotation.tailrec

object session {
  def sumTailRec(f: Int => Int)(a: Int, b: Int): Int = {
    @tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }

  sumTailRec((x: Int) => x)(0, 10)
  sumTailRec((x: Int) => x * x)(0, 10)

  //Write iterated product
  def product(f: Int => Int)(a: Int, b: Int): Int = {
      if (a > b) 1
      else f(a) * product(f)(a+1, b)
  }

  //sanity check
  product(x => x)(1, 3)

  //write factorial in terms of product
  def factorial(x: Int): Int = product(x => x)(1,x)

  //sanity check
  factorial(5)
  factorial(0)

  //Generalize sum and product?
  def mapReduce(f: Int => Int)
               (op: (Int, Int) => Int, unit: Int)
               (a: Int, b: Int): Int = {
      if(a > b) unit
      else op(f(a), mapReduce(f)(op, unit)(a+1, b))
  }

  //reimplement sum & product in terms of mapReduce
  def sum(f: Int => Int)(a: Int, b: Int) =
    mapReduce(f)((a, b) => a + b, 0)
  def prod(f: Int => Int)(a: Int, b: Int) =
    mapReduce(f)((a, b) => a * b, 1)

  //sanity check
  sum(x => x)(0, 10)
  prod(x => x)(1, 3)
}
