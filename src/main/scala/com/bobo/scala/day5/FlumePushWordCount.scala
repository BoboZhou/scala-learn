package com.bobo.scala.day5

import org.apache.spark.SparkConf
import org.apache.spark.streaming.flume.FlumeUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by ZX on 2015/6/22.
  */
object FlumePushWordCount {

  def main(args: Array[String]) {

    LoggerLevels.setStreamingLogLevels()
    val conf = new SparkConf().setAppName("FlumeWordCount").setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(30))
    //推送方式: flume向spark发送数据
    val flumeStream = FlumeUtils.createStream(ssc, "172.28.10.219", 8888)
    //flume中的数据通过event.getBody()才能拿到真正的内容
    val words = flumeStream.flatMap(x => new String(x.event.getBody().array()).split(" ")).map((_, 1))

    val results = words.reduceByKey(_ + _)
    results.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
