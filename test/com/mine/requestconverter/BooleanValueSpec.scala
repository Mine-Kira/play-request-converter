package com.mine.requestconverter

import org.specs2.mutable.Specification

class BooleanValueSpec extends Specification {
  val map = Map("one" -> Seq("1"), "zero" -> Seq("0"), "true" -> Seq("true"),
    "True" -> Seq("TRUE"), "False" -> Seq("FALSE"), "false" -> Seq("false"),
    "Yes" -> Seq("YES"), "No" -> Seq("NO"), "yes" -> Seq("yes"),
    "no" -> Seq("no"), "One" -> Seq("ONE"), "Zero" -> Seq("ZERO"),
    "no_bool" -> Seq("hello"))
  "The BooleanValue(map, key) " should {
    " return Right(true) if 1 " in {
      BooleanValue(map, "one") must equalTo(Right(true))
    }
    " return Right(false) if 0 " in {
      BooleanValue(map, "zero") must equalTo(Right(false))
    }
    " return Right(true) if true " in {
      BooleanValue(map, "true") must equalTo(Right(true))
    }
    " return Right(false) if false " in {
      BooleanValue(map, "false") must equalTo(Right(false))
    }
    " return Right(true) if yes " in {
      BooleanValue(map, "yes") must equalTo(Right(true))
    }
    " return Right(false) if no " in {
      BooleanValue(map, "no") must equalTo(Right(false))
    }
    " return Right(true) if TRUE " in {
      BooleanValue(map, "True") must equalTo(Right(true))
    }
    " return Right(false) if FALSE " in {
      BooleanValue(map, "False") must equalTo(Right(false))
    }
    " return Right(true) if YES " in {
      BooleanValue(map, "Yes") must equalTo(Right(true))
    }
    " return Right(false) if NO " in {
      BooleanValue(map, "No") must equalTo(Right(false))
    }
    " return Right(true) if One " in {
      BooleanValue(map, "One") must equalTo(Right(true))
    }
    " return Right(false) if Zero " in {
      BooleanValue(map, "Zero") must equalTo(Right(false))
    }
    " return Left if key is not present on the map " in {
      BooleanValue(map, "test") must equalTo(Left("no such key"))
    }
    " return Left if value is not on the BooleanValue " in {
      BooleanValue(map, "no_bool") must equalTo(Left("not a boolean value"))
    }
  }

  "The BooleanValue.boolToInt(value, default) " should {
    " return 1 if passed is true" in {
      BooleanValue.boolToInt(true) must equalTo(1)
    }
    " return 0 if passed is false" in {
      BooleanValue.boolToInt(false) must equalTo(0)
    }
  }

  "The BooleanValue(key) " should {
    " return Right(true) if 1 " in {
      BooleanValue("1") must equalTo(Right(true))
    }
    " return Right(false) if 0 " in {
      BooleanValue("0") must equalTo(Right(false))
    }
    " return Right(true) if true " in {
      BooleanValue("true") must equalTo(Right(true))
    }
    " return Right(false) if false " in {
      BooleanValue("false") must equalTo(Right(false))
    }
    " return Right(true) if yes " in {
      BooleanValue("yes") must equalTo(Right(true))
    }
    " return Right(false) if no " in {
      BooleanValue("no") must equalTo(Right(false))
    }
    " return Right(true) if TRUE " in {
      BooleanValue("TRUE") must equalTo(Right(true))
    }
    " return Right(false) if FALSE " in {
      BooleanValue("FALSE") must equalTo(Right(false))
    }
    " return Right(true) if YES " in {
      BooleanValue("YES") must equalTo(Right(true))
    }
    " return Right(false) if NO " in {
      BooleanValue("NO") must equalTo(Right(false))
    }
    " return Right(true) if True " in {
      BooleanValue("True") must equalTo(Right(true))
    }
    " return Right(false) if False " in {
      BooleanValue("False") must equalTo(Right(false))
    }
    " return Right(true) if Yes " in {
      BooleanValue("Yes") must equalTo(Right(true))
    }
    " return Right(false) if No " in {
      BooleanValue("No") must equalTo(Right(false))
    }
    " return Left(false) if No " in {
      BooleanValue("noo") must equalTo(Left("not a boolean value"))
    }
  }

}