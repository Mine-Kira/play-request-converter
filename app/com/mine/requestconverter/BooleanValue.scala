package com.mine.requestconverter

/**
 * Convert values to boolean value
 */
object BooleanValue {

  /**
   * Possible Boolean Values
   */
  object Value {
    val TRUE = "TRUE"
    val YES = "YES"
    val NO = "NO"
    val FALSE = "FALSE"
    val ONE = "1"
    val ZERO = "0"
    val ONE_STR = "ONE"
    val ZERO_STR = "ZERO"
  }

  /**
   * Get a boolean value based on the key, Some(Boolean) if valid None if not
   * @param map	the request body to be extract
   * @param key	the key value to find
   * @return Either[String, Boolean] - String Error, Boolean Value
   */
  def apply(map: Map[String, Seq[String]], key: String) = {
    try {
      map.get(key).head.head.toUpperCase() match {
        case Value.ONE | Value.TRUE | Value.YES | Value.ONE_STR => Right(true)
        case Value.ZERO | Value.FALSE | Value.NO | Value.ZERO_STR => Right(false)
        case _ => Left("not a boolean value")
      }
    } catch {
      case exp: NoSuchElementException => Left("no such key")
    }
  }

  /**
   * Convert value to boolean if possible
   * @param value	value to convert
   * @return Either[String, Boolean] - String Error, Boolean Value
   */
  def apply(value: String) = {
    value.toUpperCase() match {
      case Value.ONE | Value.TRUE | Value.YES | Value.ONE_STR => Right(true)
      case Value.ZERO | Value.FALSE | Value.NO | Value.ZERO_STR => Right(false)
      case _ => Left("not a boolean value")
    }
  }

  /**
   * convert Boolean to it's Integer counterpart
   * @param value	boolean to convert into integer
   * @param default	optional default value if value is not valid
   * @return Integer	Integer counterpart of value
   */
  def boolToInt(value: Boolean, default: Int = 1) = {
    value match {
      case true => 1
      case false => 0
      case _ => default
    }
  }

}