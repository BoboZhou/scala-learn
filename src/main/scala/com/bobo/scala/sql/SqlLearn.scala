package com.bobo.scala.sql

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by bobo on 2017/8/8.
  */
object SqlLearn {
  def main(args: Array[String]): Unit = {
    //创建SparkConf()并设置App名称
    val conf = new SparkConf().setAppName("SQL-2").setMaster("local")

    //SQLContext要依赖SparkContext
    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)
    System.setProperty("user.name", "root");
    val lineRdd = sc.textFile("hdfs://hdp01:9000/person.txt", 1).map(_.split(" "))

    var personRdd = lineRdd.map(x => Person(x(0).toInt, x(1), x(2).toInt))
    //5.将personRDD转换成DataFrame
    import sqlContext.implicits._
    val personDf = personRdd.toDF
    personDf.registerTempTable("person")
    val result = sqlContext.sql("select * from person").show()
    //停止Spark Context

    val re = sqlContext.sql("select * from person order by age desc limit 2")
    /*re.save("hdfs://hdp01:9000/sql/res1")
    re.save("hdfs://hdp01:9000/sql/res2", "json")*/
    val dataFrame = sqlContext.load("hdfs://hdp01:9000/sql/res2", "json").show()

    sc.stop()
  }

}
