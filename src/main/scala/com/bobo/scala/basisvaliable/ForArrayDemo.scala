package com.bobo.scala.basisvaliable

/**
  * Created by bobo on 2017/7/12.
  */
object ForArrayDemo {
  def main(args: Array[String]): Unit = {
    var arr = Array(1, 2, 3, 4, 5)
    for (i <- (0 until arr.length).reverse) {
      println(arr(i))
    }
  }

}
