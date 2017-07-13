package com.bobo.scala.basisvaliable

/**
  * Created by bobo on 2017/7/12.
  */
object BlockExpressionDemo {
  def main(args: Array[String]): Unit = {
    val x = 0
    val result = {
      if (x > 0)
        3
      else
        "error"
    }
    println(result)

    for (i <- 1 to 10) {
      println(i)
    }
    var arr = Array(1, 2, 3, 4)
    for (i <- arr) {
      print(i + "")
    }
    for (i <- 1 to 3 if i > 1; j <- 2 to 4 if i == j) {
      println(j, ":", i)
    }
    val v = for (i <- 1 to 10)
      yield i * 10
    println(v)

    val i = 1;
    val g = 2;
    println(1.+(g))
  }
}
