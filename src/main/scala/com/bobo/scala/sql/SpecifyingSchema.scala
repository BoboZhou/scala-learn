package com.bobo.scala.sql

import org.apache.spark.sql.{SaveMode, Row, SQLContext}
import org.apache.spark.sql.types._
import org.apache.spark.{SparkContext, SparkConf}

object SpecifyingSchema {
  def main(args: Array[String]) {
    //创建SparkConf()并设置App名称
    val conf = new SparkConf().setAppName("SQL-2").setMaster("local")
    //SQLContext要依赖SparkContext
    val sc = new SparkContext(conf)
    val a = sc.parallelize(1 to 9, 3)

    def iterFunc[T](iter: Iterator[T]): Iterator[(T, T)] = {
      var res = List[(T, T)]
      var pre = iter.next()
      while (iter.hasNext) {
        val cur = iter.next()
        res = res :: (pre, cur)
        per = cur
      }

    }

    //创建SQLContext
    val sqlContext = new SQLContext(sc)
    //从指定的地址创建RDD
    val personRDD = sc.textFile("hdfs://hdp01:9000/person.txt").map(_.split(" "))
    personRDD.count()
    //通过StructType直接指定每个字段的schema
    val schema = StructType(
      List(
        StructField("id", IntegerType, true),
        StructField("name", StringType, true),
        StructField("age", IntegerType, true)
      )
    )
    //将RDD映射到rowRDD
    val rowRDD = personRDD.map(p => Row(p(0).toInt, p(1).trim, p(2).toInt))
    //将schema信息应用到rowRDD上
    val personDataFrame = sqlContext.createDataFrame(rowRDD, schema)
    //注册表
    personDataFrame.registerTempTable("t_person")
    //执行SQL
    val df = sqlContext.sql("select * from t_person order by age desc limit 4")
    //将结果以JSON的方式存储到指定位置
    df.write.json("hdfs://hdp01:9000/sql/res3")
    //停止Spark Context
    sc.stop()
  }
}
