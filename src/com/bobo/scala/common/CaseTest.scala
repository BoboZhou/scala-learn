package com.bobo.scala.common

import com.bobo.scala.Rat

/**
  * Created by bobo on 2017/7/6.
  */
object CaseTest {
  def main(args: Array[String]): Unit = {
    var l = "bobo"
    l match {
      case "bobo" =>
      case "bobo" =>
        println("1")
      case "bb" =>
        println("hh")
        println("less")
    }
    val test = 1 match {
      case 1 =>
      case 2 => {
        println(2)
      }
    }
    var result = 1 match {
      case 2 => 3
      case 1 => 100
    }
    val a = new Rat(1, 2)
    val b = new Rat(1, 2)
    println(a == b)
    println(a eq b)
    println(a ne b)
    println(!a.eq(b))
    // println(result)
    val item = new Rat(1, 2)
    println(item.isInstanceOf[Rat])

  }
}
