package com.bobo.scala.day5

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by bobo on 2017/8/8.
  */
object NetworkWordCountBobo {
  def main(args: Array[String]): Unit = {
    //设置日志级别
    //创建SparkConf并设置为本地模式运行
    //注意local[2]代表开两个线程
    val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
    //设置DStream批次时间间隔为2秒
    val ssc = new StreamingContext(conf, Seconds(5))
    val lines = ssc.socketTextStream("hdp01", 9999)

  }

}
