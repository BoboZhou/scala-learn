package com.bobo.scala.basisvaliable

/**
  * Created by bobo on 2017/7/12.
  */
object ArrayYieldDemo {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5, 6)
    val res = for (i <- arr if i % 2 == 0)
      yield i * 10

    println(res.toBuffer)
    val r = arr.filter(_% 2 == 0).map(_*100)
    println(r.toBuffer)
    println(arr.sum)
    println(arr.max)
  }
}
