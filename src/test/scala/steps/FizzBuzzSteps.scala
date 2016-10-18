package steps

import Kata.FizzBuzz
import sun.security.util.PendingException
  import cucumber.api.scala.{EN, ScalaDsl}
  import org.scalatest.FlatSpec



  class FizzBuzzSteps extends FlatSpec with ScalaDsl with EN {

    When("""^The current number is not a product or (\d+) or (\d+)$"""){ (arg0:Int, arg1:Int) =>
      val fizzBuzz = new FizzBuzz(10)
      assert(fizzBuzz.getResult(4) == "4")
      assert(fizzBuzz.getResult(1) == "1")

    }
    Then("""^The current number is printed$"""){ () =>
      val fizzBuzz = new FizzBuzz(18)
      fizzBuzz.printAllResultsForRange
      assert(fizzBuzz.getResult(4) == "4")
      assert(fizzBuzz.getResult(1) == "1")
      assert(fizzBuzz.getResult(3) == "fizz")
      assert(fizzBuzz.getResult(5) == "buzz")
      assert(fizzBuzz.getResult(15) == "fizzbuzz")
      assert(fizzBuzz.getResult(16) == "16")
      assert(fizzBuzz.getResult(18) == "fizz")
    }
}
