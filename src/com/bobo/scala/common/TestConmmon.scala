package com.bobo.scala.common

/**
  * Created by bobo on 2017/7/5.
  */
object TestConmmon {
  def main(args: Array[String]): Unit = {
    val incr = (x: Int) => x + 1
    println(incr(1))
    var add = (x: Int) => x + 9
    println(add(1))
    var less = (x: Int, y: String) => {
      val c = x + 3
      println(y)
      println(x)
      c
    }
    less(4, "bobo")
    val someNumber = List(1, 2, 3, 45, 7)
    someNumber.foreach((x: Int) => println(x))
    val filter = someNumber.filter((x: Int) => x > 3)
    filter.foreach((x: Int) => println("g", x))
    val te = (x: Any) => {
      println("any")
      println(x)
    }
    te("bb")
    var more = 1;
    var addMore = (x: Int) => x + more
    println(addMore(3))
    var sum = 0;
    someNumber.foreach((x: Int) => sum += x)
    println(sum)

    def mkIncr(more: Int) = (x: Int) => x + more;
    println(mkIncr(1)(1))
    println(mkIncr(99)(1))

    def lop(x: Int, tim: Int): Int = {

      if (x == 0)
        return tim
      else
        lop(x - 1, tim + 1)
    }

    println(lop(5, 0))

  }

}
