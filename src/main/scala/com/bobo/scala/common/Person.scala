package com.bobo.scala.common

/**
  * Created by bobo on 2017/7/13.
  */
class Person {
  val id = 2311
  var age: Int = 18
  private var name: String = "boob"
  private[this] val pet = "小强"

  def printl(x: AnyVal): Unit = {
    println(name)
  }
}
