package com.bobo.scala.common

/**
  * Created by bobo on 2017/7/6.
  */
object ListTest {
  def main(args: Array[String]): Unit = {
    var list = List(1, 2, 3, 4, "t")
    var filr = List("a", "b", "c")
    val l4 = List(list, filr)
    println(l4)
    val value = new Person
    println(value.age, "", value.id)
    val student = new Student("bobo",23)
    println(student.age,student.name)
    val student1 = new Student("lanlan",33,"nv")



  }

}
