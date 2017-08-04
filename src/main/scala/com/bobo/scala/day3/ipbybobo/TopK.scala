package com.bobo.scala.day3.ipbybobo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bobo on 2017/8/4.
  */
object TopK {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]").setAppName("IpLocation")
    val sc = new SparkContext(conf)
    val rddText = sc.textFile("d:/order.txt")
    type myType = (String, Double)
    val rdd2 = rddText.map(x => {
      val lines = x.split(",")
      // user  （ item    sorce)
      (lines(0), (lines(1), lines(2).toDouble))
    }).combineByKey(x => List(x),
      (t: List[(String, Double)], s: (String, Double)) => (t :+ s),
      (c1: List[(String, Double)], c2: List[(String, Double)]) => c1 ::: c2)

    val rdd6 = rdd2.map(x => {
      var user = x._1
      var sourceArr = x._2.map(x => (1, x._2)).reduce((x, y) => (x._1 + y._1, x._2 + y._2))
      (user, sourceArr._2 / sourceArr._1)

    })
    val rddTop = rdd2.map(x=>{
      (x._1,x._2.sortWith())
    })
    println(rdd2.collect().toBuffer)
    sc.stop()
  }
}
