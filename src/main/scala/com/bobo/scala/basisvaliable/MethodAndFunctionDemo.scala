package com.bobo.scala.basisvaliable

/**
  * Created by bobo on 2017/7/12.
  */
object MethodAndFunctionDemo {
  def main(args: Array[String]): Unit = {
    def ml(fa: (Int, Int) => Int): Int = {
      fa(2, 6)
    }

    val f1 = (x: Int, y: Int) => x + y
    val f2 = (m: Int, n: Int) => m * n
    println(ml(f1))
    println(ml(f2))

    def sl(sk: (String, String) => String) = {
      sk("bobo", "gg")
    }

    val g = (s1: String, s2: String) => s1 + s2
    println(sl(g))
  }

}
