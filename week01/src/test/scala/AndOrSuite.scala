package AndOr

import org.scalatest.FunSuite
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import AndOr._

@RunWith(classOf[JUnitRunner])
class AndOrSuite extends FunSuite {
  test("And with true/true") {
    assert(and(true, true))
  }
  test("And with true/false") {
    assert(!and(true, false))
  }
  test("And with false/true") {
    assert(!and(false, true))
  }
  test("And with false/false") {
    assert(!and(false, false))
  }


  test("Or with true/true") {
    assert(or(true, true))
  }
  test("Or with true/false") {
    assert(or(true, false))
  }
  test("Or with false/true") {
    assert(or(false, true))
  }
  test("Or with false/false") {
    assert(!or(false, false))
  }
}
