package com.bobo.scala.day3.ipbybobo

import java.io.{BufferedReader, FileInputStream, InputStreamReader}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by bobo on 2017/8/3.
  */
object IPLOcationBobo {
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

  def binarySearch(lines: ArrayBuffer[String], ip: Long): Int = {
    var low = 0;
    var hight = lines.length - 1;

    while (low <= hight) {
      var mid = (low + hight) / 2
      if (ip >= (lines(mid).split("\\|")(2).toLong) && (ip <= lines(mid).split("\\|")(3).toLong))
        return mid;
      if (ip < (lines(mid).split("\\|")(2).toLong))
        hight = mid - 1
      else low = mid + 1

    }
    -1
  }

  def main(args: Array[String]) {
    val ip = "120.55.185.61"
    val ipNum = ip2Long(ip)
    println(ipNum)
    val lines = readData("d:/ip.txt")
    val index = binarySearch(lines, ipNum)
    print(lines(index))
  }

}
