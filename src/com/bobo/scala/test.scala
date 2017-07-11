package com.bobo.scala

import java.io.File

/**
  * Created by bobo on 2017/6/30.
  */
object test {
  def main(args: Array[String]): Unit = {
    val c = TestCase(8);
    println(c.getLong())
    val rat = new Rat(1, 1)
    val add = rat.add(rat)
    println(add.denom)
    println(add.number)
    var l = new Rat(3)
    var fileName = new File(".").listFiles()
    for (fiel <- fileName if fiel.getName.contains(".")) {
      println(fiel)
    }
    for (file <- fileName
         if file.isFile;
         if file.getName().contains("."))
      println("idf", file)
    for (i <- 1 to 5) {
      println(i)
    }
    for (i <- 1 until (5)) {
      println(i)
    }
    println(gcd(1, 4))

  }

  def gcd(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
      var temp = a
      a = b % a
      b = temp
    }
    b
  }
}
