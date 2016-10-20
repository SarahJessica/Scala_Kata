package Kata

class FizzBuzz(countUpToInt: Int, startInput: Int = 1) {

    // getters
    def getStartInput: Int = startInput
    def getCountUpToInt: Int = countUpToInt

    // methods

    def getResult(num: Int): String = {

        val result = ((num % 3), (num % 5)) match {
            case (0, 0) => "fizzbuzz"
            case (0, _) => "fizz"
            case (_, 0) => "buzz"
            case _ => num.toString
        }

        result
    }

  def printAllResultsForRange: Unit = {

    startInput to countUpToInt foreach { i =>
      resultPrinter(getResult(i))
    }

  }

  def resultPrinter(result: String): Unit = println(result)

}
