package com.bobo.scala.day2

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bobo on 2017/7/31.
  */
object UserLocationBobo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ForeachDemo").setMaster("local[2]")
    val sc = new SparkContext(conf)

    val mbt = sc.textFile("d://bs_log").map(x => {
      val arr = x.split(",")
      val k = arr(1)
      val time = if (k == "1") -k.toLong else k.toLong
      ((arr(0), arr(2)), time)
    }).reduceByKey(_ + _)
      .map(s => {
        (s._1._2, (s._1._1, s._2))
      })

    val rdd3 = sc.textFile("d://loc_info.txt").map(x => {
      val line = x.split(",")
      (line(0), (line(1), line(2)))
    }).join(mbt).map(x => {
      (x._2._2._1, (x._1, x._2._2._2, x._2._1._1, x._2._1._2))
    })
    rdd3.map(x => {
      (x._1+"-"+x._2._1,(x._2._1,x._2._3,x._2._4))
    })
    println(rdd3.collect().toBuffer)
    sc.stop()
  }

}
