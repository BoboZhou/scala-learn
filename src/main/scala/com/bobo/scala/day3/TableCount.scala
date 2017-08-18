package com.bobo.scala.day3

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bobo on 2017/8/14.
  * TableName(表名)，Time(时间)，User(用户)，TimeSpan(时间开销)
  * 要求编写MapReduce程序算出高峰时间段（如上午10点）
  * 哪张表被访问的最频繁，以及这段时间访问这张表最多的用户，以及这个用户的总时间开销。
  */
object TableCount {
  def main(args: Array[String]): Unit = {
    //创建SparkConf()并设置App名称
    val conf = new SparkConf().setAppName("SQL-2").setMaster("local")

    //SQLContext要依赖SparkContext
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("D:\\3期\\code\\scala-learn\\src\\main\\resources\\TabCount.txt")
      .map(s => {
        val line = s.split(" ")
        //("table-time,(user,usertime))
        (line(0) + "-" + line(1), (line(2), line(3)))
      }).filter(f => {
      f._1.split("-")(1).equals("10:00")
    })
    rdd.cache()
    val rdd2 = rdd.map(t => {
      (t._1, 1)
    })

    val rdd3 = rdd2.reduceByKey(_ + _).sortByKey(true).take(2)
    rdd2.cache()
    val rdd4 = rdd2.join(rdd)
    println(rdd4.collect().toBuffer)
  }

}
