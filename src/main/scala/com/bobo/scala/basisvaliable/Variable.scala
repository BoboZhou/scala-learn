package com.bobo.scala.basisvaliable

/**
  * Created by bobo on 2017/7/12.
  */
object Variable {
  def main(args: Array[String]): Unit = {
    val i = 1
    var s = "hello"
    val str: String = "bobo"
    val y = if (i > 1) 2 else 0;
    println(y)
    val b = if (y > 0) 3 else -3
    println(b)
    val l = if (b > 0) 5 else "hh"
    println(l)
    val gg = if (b > 0) 6 else ()
    println(gg)

  }
}
