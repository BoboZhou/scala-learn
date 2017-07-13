package com.bobo.scala.common

/**
  * Created by bobo on 2017/7/13.
  */
object PartialFuncDemo {
  def fun1: PartialFunction[String, Int] = {
    case "one" => 1
    case "tow" => 2
    case _ => 1
  }

  def fun2(num: String): Int = num match {
    case "one" => 1
    case "tow" => 2
    case _ => 1
  }

  def main(args: Array[String]) {
    println(fun1("one"))
    println(fun2("one"))
  }


}
