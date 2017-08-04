package com.bobo.scala.day3.ipbybobo

import java.io.{BufferedReader, FileInputStream, InputStreamReader}
import java.sql.{Connection, Date, DriverManager, PreparedStatement}

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by bobo on 2017/8/3.
  */
object IPLocationBo {
  val data2Mysql = (iter: Iterator[(String, Int)]) => {
    var conn: Connection = null;
    var ps: PreparedStatement = null
    val sql = "INSERT INTO location_info (location, counts, accesse_date) VALUES (?, ?, ?)"
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigdata?Unicode=true&characterEncoding=utf-8", "root", "zhouyubo123")
    iter.foreach(line => {
      ps = conn.prepareStatement(sql)
      ps.setString(1, line._1)
      ps.setInt(2, line._2)
      ps.setDate(3, new Date(System.currentTimeMillis()))
      ps.executeUpdate()
    })
  }

  def ip2Long(ip: String): Long = {
    val fragments = ip.split("[.]")
    var ipNum = 0L
    for (i <- 0 until fragments.length) {
      ipNum = fragments(i).toLong | ipNum << 8L
    }
    ipNum
  }

  def readData(path: String) = {
    val br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))
    var s: String = null;
    var flag = true;
    val lines = new ArrayBuffer[String]()
    while (flag) {

      s = br.readLine();
      if (s != null)
        lines += s
      else
        flag = false
    }
    lines
  }

  def binarySearch(lines: Array[(String, String, String)], ip: Long): Int = {
    var low = 0;
    var hight = lines.length - 1;

    while (low <= hight) {
      var mid = (low + hight) / 2
      if ((ip >= (lines(mid)._1.toLong) && (ip <= lines(mid)._2.toLong)))
        return mid;
      if (ip < (lines(mid)._1.toLong))
        hight = mid - 1
      else low = mid + 1

    }
    -1
  }

  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[2]").setAppName("IpLocation")
    val sc = new SparkContext(conf)
    val ipRulesRdd = sc.textFile("d://ip.txt").map(
      line => {
        val lin = line.split("\\|")
        var startNum = lin(2)
        var endNum = lin(3)
        var prov = lin(6)
        (startNum, endNum, prov)
      })

    //广播全部的IP规则
    var ipArray = ipRulesRdd.collect();
    val broadcast = sc.broadcast(ipArray)
    //加载处理测数据
    val ipRdd = sc.textFile("d://access_log.log").map(line => {
      val lineArr = line.split("\\|")
      val ip = lineArr(1)
      (ip)
    })
    var result = ipRdd.map(ip => {
      var ipNum = ip2Long(ip)
      var index = binarySearch(broadcast.value, ipNum)
      var info = broadcast.value(index)
      info
    }).map(x => {
      (x._3, 1)
    }).reduceByKey(_ + _)
    result.foreachPartition(data2Mysql(_))

    println(result.collect().toBuffer)

    sc.stop()
  }
}
