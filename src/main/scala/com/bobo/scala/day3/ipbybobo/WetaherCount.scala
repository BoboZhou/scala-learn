package com.bobo.scala.day3.ipbybobo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bobo on 2017/8/18.
  * 计算每年降水量代码统计
  */
object WetaherCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("JdbcRDDDemo").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("d:/f21982.dat")
    val rdd2 = rdd.map(line => {
      line.trim().replace("   ", " ").replace("  ", " ").split(" ")

    }).filter(_.length == 15).filter(_ (13) != "9").filter(_ (11) != "999.9")
    val everyYearRdd = rdd2.map(tup => {
      (tup(1), tup(11).toDouble)
    }).groupByKey().map(yearTup => {
      (yearTup._1, yearTup._2.reduce(_ + _))
    }).sortBy(_._2,false)
    println(everyYearRdd.collect().toBuffer)
//
  }

}
