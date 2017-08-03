package com.bobo.scala.day1

import java.net.URL

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 2016/5/14.
  */
object WordCount {
  def main(args: Array[String]) {
    //非常重要，是通向Spark集群的入口
   val url = new URL("http://java.itcast.cn/java/course/javaeeadvanced.shtml")
    println(url.getHost)
    println(url.getPath)
    println(url.getPort)
  }
}
