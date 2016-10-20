package utils.Kata

import org.scalatest.{MustMatchers, FlatSpec}
import Kata.FizzBuzz

class FizzBuzzTest extends FlatSpec with MustMatchers {

    "FizzBuzz" must "return the same number as a string if not divisible by 3 or 5" in {
        val fizzBuzz = new FizzBuzz(4)
        fizzBuzz.getResult(1) mustBe "1"
        fizzBuzz.getResult(2) mustBe "2"
        fizzBuzz.getResult(4) mustBe "4"
    }

    it must "return fizz if the number is divisible by 3" in {
        val fizzBuzz = new FizzBuzz(7)
        fizzBuzz.getResult(3) mustBe "fizz"
        fizzBuzz.getResult(6) mustBe "fizz"
        fizzBuzz.getResult(6) must not be "6"
    }

    it must "return buzz if the number is divisible by 5" in {
        val fizzBuzz = new FizzBuzz(12)
        fizzBuzz.getResult(5) mustBe "buzz"
        fizzBuzz.getResult(10) mustBe "buzz"
        fizzBuzz.getResult(10) must not be "10"
    }

    it must "return fizzbuzz if the number is divisible by 3 and 5" in {
        val fizzBuzz = new FizzBuzz(100)
        fizzBuzz.getResult(15) mustBe "fizzbuzz"
        fizzBuzz.getResult(45) mustBe "fizzbuzz"
        fizzBuzz.getResult(90) mustBe "fizzbuzz"
        fizzBuzz.getResult(100) must not be "100"
        fizzBuzz.getResult(60) must not be "buzz"
    }
}
