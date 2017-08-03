package com.bobo.scala.day2

import java.net.URL

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bobo on 2017/7/31.
  */
object AdvUrlCountBobo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("AdvUrlCount").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val text = sc.textFile("d://itcast.log")
    val rdd3 = text.map(line => {
      val split = line.split("\t")
      (split(1), 1)
    }).reduceByKey(_ + _).map(tup => {
      val url = tup._1
      val count = tup._2
      val url1 = new URL(url)
      (url1.getHost, url, count)
    })
    val rdd6 = rdd3.map(t => {
      val souce = t._2.split("/")
      val key = souce(3) + "-" + souce(4)
      val count = t._3
      (key, count)
    })
    println(rdd6.reduceByKey(_ + _).collect().toBuffer)
    val rdd4 = rdd3.map(t => {
      (t._1, t._3)
    }).reduceByKey(_ + _).sortByKey(false)
    println(rdd4.collect().toBuffer)
    val arr = Array("java.itcast.cn", "php.itcast.cn", "net.itcast.cn")
    for (elem <- arr) {
      val rdd7 = rdd3.filter(elem == _._1)
      println(rdd7.collect().toBuffer)

    }
  }
}
