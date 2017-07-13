package com.bobo.scala.basisvaliable

import scala.collection.mutable.ArrayBuffer

/**
  * Created by bobo on 2017/7/12.
  */
object ArrayDemo {
  def main(args: Array[String]): Unit = {
    val intArr = new Array[Int](10)
    println(intArr)
    println(intArr.toBuffer)
    var arr3 = Array("bobo", "kk")
    println(arr3.toBuffer)
    println(arr3(0))
    // 缓冲数组
    val buffer = ArrayBuffer[Int]()
    buffer += 1;
    buffer += (1, 2, 4)
    buffer ++= Array(5, 6)
    buffer ++= ArrayBuffer(7, 8)
    println(buffer)
    buffer.insert(0,-1,9,10)
    println(buffer)


  }

}
