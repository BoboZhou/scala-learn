package com.bobo.scala

import java.io.File

/**
  * Created by bobo on 2017/6/30.
  */
object Line {
  def main(args: Array[String]): Unit = {
    var line = ""
  /*  do {
      line = readLine()
      println("read：" + line)
    } while (line != "")*/
  }

  def greet(): Unit = {
    println("bobo")
  }

  println(greet() == ())
  println("bbbb")
  var fileName = new File(".").listFiles()

  def grep(pat: String) = {


  }

  def scafile = {
    for {
      file <- fileName
      if file.getName.contains(".")
    } yield file
  }

  private val scafile1 = scafile
  println(scafile1)
  var incre = (x: Int) => x + 1
  println(incre(1))
  var inc = (x: Int) => {
    println("wer")
    x + 99
  }
  println(inc(1))

}
