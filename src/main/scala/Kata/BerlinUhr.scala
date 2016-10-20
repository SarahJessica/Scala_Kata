package Kata

object BerlinUhr {

  def seconds(secs: Int): String = {
    if (secs % 2 == 0) "Y" else "O"
  }

  def topHours(hours: Int): String = {
    (for (l <- 1 to 4) yield
      if (l<= hours/5) "R" else "O").mkString("")
  }

  def bottomHours(hours: Int): String = {
    (for (i <- 1 to 4) yield
      if (i <= hours%5) "R" else "O").mkString("")
  }

  def topMinutes(mins: Int): String = {
    (for (g <- 1 to 11 ) yield {
      if (mins !=0 && mins % 15 == 0) "R"
      else {
        if (g <= mins / 11) "Y" else "O"
      }
    }).mkString("")
  }

  def bottomMinutes(mins: Int): String = { "OOOO"}


}
