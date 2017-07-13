package com.bobo.scala.common

/**
  * Created by bobo on 2017/7/13.
  */
class Queen private(val name: String, prop: Array[String], private val age: Int = 18) {
  println(prop.size)

  def des = name + "is" + age + "years:" + prop.toBuffer

}

object Queen {
  def main(args: Array[String]): Unit = {
    val queen = new Queen("bobo", Array("蜡烛", "皮鞭"), 20)
    println(queen.des)
    queen.des

  }
}
