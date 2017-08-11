package com.bobo.scala.actor

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bobo on 2017/8/9.
  */
object MyCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("FlumePollWordCount").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val lineRdd = countYinKui("D:\\3期\\code\\scala-learn\\src\\main\\resources\\te.txt", sc)
    val lineRdd1 = kunShunCount("D:\\3期\\code\\scala-learn\\src\\main\\resources\\te.txt", sc)
    val map = lineRdd1.map(_._2.toBuffer)
    println(map.take(3).toBuffer)


  }

  /**
    * 统计总盈亏
    *
    * @param path
    * @param sc
    * @return
    */
  def countYinKui(path: String, sc: SparkContext): Any = {
    val lineRdd = sc.textFile(path)
      .map(_.split("\t")).map(x => {
      ("总盈亏", try {
        x(7).toDouble
      } catch {
        case _ => 0
      })
    }).reduce((x, y) => ("总盈亏", (x._2 + y._2)))
    lineRdd
  }

  /**
    * 亏损前3
    */
  def kunShunCount[T](path: String, sc: SparkContext): RDD[(Double, Array[String])] = {
    val lineRdd = sc.textFile(path)
      .map(_.split("\t")).map(x => {
      (try {
        x(7).toDouble
      } catch {
        case _ => 0
      }, x)
    }).sortBy(_._2(7),false)
    lineRdd
  }
}
