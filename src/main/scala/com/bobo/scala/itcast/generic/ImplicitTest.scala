package com.bobo.scala.itcast.generic

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bobo on 2017/7/20.
  */
object ImplicitTest {

  /**
    * Implicit实现隐式参数
    */
  object Context {
    implicit val str: String = "implicit parameter"
    implicit val bobo: String = "bobo"
  }

  object Parameter {
    def print(context: String)(implicit prefix: String): Unit = {
      println(prefix + ":" + context)
    }

    def printlnBobo(context: String)(implicit bobo: String): Unit = {
      println(bobo + ":" + context)
    }


  }

  def main(args: Array[String]) {
    Parameter.print("Hello")("Scala")
    //在此使用隐式参数
    import Context.bobo
    Parameter.printlnBobo("Scala")
    val a = new A(1)
    a.show
    //非常重要，是通向Spark集群的入口
    val conf = new SparkConf().setAppName("AdvUserLocation").setMaster("local[2]")
    val sc = new SparkContext(conf)
    fun1(sc, "D:\\app\\topK.txt", "D:\\app1\\topKOut.txt", 1, 1)
  }

  def fun1(sc: SparkContext, input: String, output: String, k: Int, num: Int) = {
    val start = System.currentTimeMillis;
    val text = sc.textFile(input, num)
      val mp = text.map { x => val f = x.split(","); (f(0), (f(1), f(2).toDouble)) }
    val combin = mp.combineByKey((x: (String, Double)) => List(x),
      (c: List[(String, Double)], x: (String, Double)) => c :+ x,
      (c1: List[(String, Double)], c2: List[(String, Double)]) => c1 ::: c2)
    combin.map(x => (x._1, x._2.sortWith((x, y) => x._2 > y._2).take(10))).
      saveAsTextFile(output)
    println("fun1,k: " + k + ",input:" + input + ",num:" + num + "---> time:" +
      (System.currentTimeMillis - start) * 1.0 / 1000 + " s")
  }

  def sorted[B >: A](implicit ord: scala.math.Ordering[B]): AnyVal = {

  }


  class A(val data: Int) {

  }

  implicit class B(a: A) {
    def show {
      println(a.data)
    }
  }

}
