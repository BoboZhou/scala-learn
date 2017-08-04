package com.bobo.scala.day3.ipbybobo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bobo on 2017/8/4.
  */
object ComBinTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]").setAppName("IpLocation")
    val sc = new SparkContext(conf)
    val initialScores = Array(("Fred", 88.0), ("Fred", 95.0), ("Fred", 91.0), ("Wilma", 93.0), ("Wilma", 95.0), ("Wilma", 98.0))
    val d1 = sc.parallelize(initialScores)
    type MVType = (Int, Double)
    //定义一个元组类型(科目计数器,分数)
    d1.combineByKey(s => (1, s),
      (s: MyType, x: Double) => (s._1 + 1, s._2 + x),
      (c1: MVType, c2: MVType) => (c1._1 + c2._1, c1._2 + c2._2))
    val rdd4 = d1.combineByKey(
      score => {
        println(score)
        (1, score)
      },
      (c1: MVType, newScore) => (c1._1 + 1, c1._2 + newScore),
      (c1: MVType, c2: MVType) => (c1._1 + c2._1, c1._2 + c2._2)
    ).map { case (name, (num, socre)) => (name, socre / num) }.collect
    val d2 = sc.parallelize(initialScores)
    type MyType = (Int, Double)

    val dd4 = d1.combineByKey(s => {
      (1, s)
    },
      (s: MVType, v) => {
        (s._1 + 1, s._2 + v)
      }, (c1: MyType, c2: MyType) => {
        (c1._1 + c2._1, c1._2 + c2._2)
      }
    ).map { case (name, (num, source)) => {
      (name, source / num)
    }
    }
    println(dd4.collect().toBuffer)

    println(rdd4.toBuffer)
  }

}
