package com.bobo.scala.common

import java.io.FileNotFoundException

/**
  * Created by bobo on 2017/7/13.
  */
class Student(val name: String, val age: Int) {
  println("create:", name, age)
  try {
    println("duquwenjian")
    throw new FileNotFoundException()
  }
  catch {
    case e: NullPointerException => println("null")
    case e: FileNotFoundException => println("file")
    case e: Exception => println("ex")
  } finally {
    println("finally")
  }
  private var gender = "jbobo"

  def this(name: String, age: Int, gender: String) {
    this(name, age)
    println("this 构造器")
    this.gender = gender;
  }

}
