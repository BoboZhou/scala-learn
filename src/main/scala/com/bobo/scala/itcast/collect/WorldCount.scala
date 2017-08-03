package com.bobo.scala.itcast.collect


/**
  * Created by ZX on 2016/4/6.
  */
object WorldCount {
  def main(args: Array[String]) {
    val lines = Array("hello tom hello jerry", "hello tom hello jerry")
    val st = Array(1, 2, 3, 4)
    st.map((_, 1))
    val grouped = lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1)
    //val result = grouped.map(t=>(t._1, t._2.foldLeft(0)(_ + _._2)))
    val result = grouped.map(t => (t._1, t._2.foldLeft(0)((x, y) => (x + y._2))))
    st.filter(_ > 3)
    println(result)
    val mp1 = mp(fu)
    println(mp1)
    println(mm(funct))
  }


  def mp(p: Int => Int): Int = {
    p(3)
  }

  def mm(x: String => String) = {
    x("gg")
  }

  val funct = (x: String) => x + "bpb"

  val fu = (x: Int) => {
    x + 3
  }
}
