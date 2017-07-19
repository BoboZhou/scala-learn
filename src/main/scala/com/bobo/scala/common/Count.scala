package com.bobo.scala.common

import java.io.File

import scala.io.Source

/**
  * Created by bobo on 2017/7/18.
  */
object Count {
  def main(args: Array[String]): Unit = {
    val files = Array("d://words.txt", "d://words.log")
    val file = Source.fromFile(new File(files.apply(1))).mkString.split("\r\n").flatMap(_.split(" ")).map((_, 1))
      .groupBy(_._1).mapValues(_.length)
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val partition = numbers.partition(_ % 3 == 0)
    val find = numbers.find(_ % 2 == 0)
    println(partition.toString())
    println(find.mkString)
    println(file.toBuffer)
    var ext = Map("bobo" -> 100, "bob" -> 101, "job" -> 201)
    println(ext)
    val filter = ext.filter(_._2 < 200)
    println(filter)
    val filter1 = ext.filter({
      case (name, num) => num == 100
      case _ => false
    })
    println(filter1)

    val va = Map("a" -> 1, "b" -> 2, "c" -> 3)
    val values = va.mapValues({
      case (_) => 2
    })
    val values1 = va.mapValues(i => {
      if (i == 2) {
        20
      }
    })
    println(values)
    println(values1)

    val gg = ("11", 22, 33)

  }

}
