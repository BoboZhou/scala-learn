package com.bobo.scala.common

/**
  * Created by bobo on 2017/7/14.
  */
object ListCase {
  def main(args: Array[String]): Unit = {
    val list = Array(1, 2, 3, 4)
    val worrds = List("bobo", "lanlan", "kk")
    val map = list.map(_ * 10)
    println(map.toBuffer)
    val ints = worrds.map(_.length)
    println(ints)
    val kk = List("sprck" -> 1, "hive" -> 2, "lanlan" -> 3)
    val ll = List("Spark" -> 1, "hive" -> 2, "hadoop" -> 2)
    val apply = ll.apply(1)
    println(apply)
  }

}
