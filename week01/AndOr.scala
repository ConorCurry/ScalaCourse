object AndOr {
  def and(x: Boolean, y: => Boolean): Boolean = {
    if(!x) false else y
  }

  def or(x: Boolean, y: => Boolean): Boolean = {
    if(x) true else y
  }
}
