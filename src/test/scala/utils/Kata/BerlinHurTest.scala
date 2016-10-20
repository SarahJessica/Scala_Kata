package utils.Kata;


import org.scalatest.FlatSpec;
import org.scalatest.MustMatchers;
import Kata.BerlinUhr;

class BerlinHurTest extends FlatSpec with MustMatchers {

    "Yellow lamp" should "blink on/off every two seconds" in {
//        val berlinUhr = new BerlinUhr(10);
        BerlinUhr.seconds(0) must be ("Y")
        BerlinUhr.seconds(1) must be ("O")
        BerlinUhr.seconds(59) must be ("O")
    }

    "Top hours" should "have 4 lamps" in {
        BerlinUhr.topHours(7).length must be (4)
    }

    it should "light a red lamp for every 5 hours" in {
        BerlinUhr.topHours(0) must be ("OOOO")
        BerlinUhr.topHours(13) must be ("RROO")
        BerlinUhr.topHours(23) must be ("RRRR")
        BerlinUhr.topHours(24) must be ("RRRR")
    }

    "Bottom hours" should "have 4 lamps" in {
        BerlinUhr.bottomHours(5).length must be (4)
    }

    it should "light a red lamp for every hour left from top hours" in {
        BerlinUhr.bottomHours(0) must be ("OOOO")
        BerlinUhr.bottomHours(13) must be ("RRRO")
        BerlinUhr.bottomHours(23) must be ("RRRO")
        BerlinUhr.bottomHours(24) must be ("RRRR")
    }

    "Top minutes" should "have 11 lamps" in {
        BerlinUhr.topMinutes(34).length must be (11)
    }

//    it should "have 3rd, 6th and 9th lamps in red to indicate first quarter, half and last quarter" in {
//        val minutes32 = BerlinUhr.topMinutes(32)
//        println(s"********** ${minutes32(2)}")
//        minutes32(2) must be ('R')
//        minutes32(5) must be ('R')
//        minutes32(8) must be ('O')
//    }

//    it should "light a yellow lamp for every 5 minutes unless it's first quarter, half or last quarter" in {
//        BerlinUhr.topMinutes(0) must be ("OOOOOOOOOOO")
//        BerlinUhr.topMinutes(17) must be ("YYROOOOOOOO")
//        BerlinUhr.topMinutes(59) must be ("YYRYYRYYRYY")
//    }
//
    "Bottom minutes" should "have 4 lamps" in {
        BerlinUhr.bottomMinutes(0).length must be (4)
    }

//    it should "light a yellow lamp for every minute left from top minutes" in {
//        BerlinUhr.bottomMinutes(0) must be ("OOOO")
//        BerlinUhr.bottomMinutes(17) must be ("YYOO")
//        BerlinUhr.bottomMinutes(59) must be ("YYYY")
//    }
//
//    "Berlin Clock" should "result in array with 5 elements" in {
//        BerlinUhr.convertToBerlinTime("13:17:01").size must be (5)
//    }
//
//    it should "result in correct seconds, hours and minutes" in {
//        val berlinTime = BerlinUhr.convertToBerlinTime("16:37:16")
//        val expected = Array("Y", "RRRO", "ROOO", "YYRYYRYOOOO", "YYOO")
//        berlinTime should equal (expected)
//    }

}