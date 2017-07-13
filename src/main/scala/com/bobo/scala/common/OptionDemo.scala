package com.bobo.scala.common

/**
  * Created by bobo on 2017/7/13.
  */
object OptionDemo {
  def main(args: Array[String]): Unit = {
    val map = Map("a" -> 1, "b" -> 2)
    val v = map.get("b") match {
      case Some(i) => i
      case None => 0
    }
    println(v)
    val v1 = map.getOrElse("c", 0)
    println(v1)

  }

}
