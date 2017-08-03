package com.bobo.scala.basisvaliable

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bobo on 2017/7/13.
  */
object MapTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("sortsample")
    val sc = new SparkContext(conf)
    //

    var pairs = sc.parallelize(Array(("a",0),("b",0),("c",3),("d",6),("e",0),("f",0),("g",3),("h",6)), 2);
    pairs.sortByKey(true, 3).collect().foreach(println);
    var sotre = Map("tom" -> 85, "bobo" -> "60")
    println(sotre("bobo"))
    println(sotre.getOrElse("bobto", 30))
    sotre += ("lanaln" -> "100")
    println(sotre)
    var at = Array(1, 2, 3)
    at = at.map(_ * 2)
    println(at.toBuffer)
    val t = ("hadoop", 3.14, 65667)
    println(t)
    println(t._1)
    var arr = Array(("bobo", 10), ("kk", 20))
    val m = arr.toMap
    println(m)

    def md(x: Int) = (y: Int) => x * y

    val fun = md(3)
    println(fun(4))
    println(md(3)(7))

    def cc(x: Int) = (g: Int, f: Int) => x + f + g

    println(cc(1)(1, 1))
  }
}
