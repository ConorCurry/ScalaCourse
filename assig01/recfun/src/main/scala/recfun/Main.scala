package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =
      if (c <= 0 || c >= r) 1 else pascal(c-1, r-1) + pascal(c, r-1)
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      @tailrec
      def balance_aux(parens: Int, chars: List[Char]): Boolean = {
        if (chars.isEmpty) parens == 0
        else if (chars.head == '(') balance_aux(parens + 1, chars.tail)
        else if (chars.head == ')') (parens > 0) && balance_aux(parens - 1, chars.tail)
        else balance_aux(parens, chars.tail)
      }

      balance_aux(0, chars)
    }

  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def change(money: Int, coins: List[Int]): Int = {
        if (money == 0) 1
        else if (money > 0 && !coins.isEmpty) change(money - coins.head, coins) + change(money, coins.tail)
        else 0
      }

      if (money > 0) change(money, coins) else 0
    }
  }
