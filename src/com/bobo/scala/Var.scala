package com.bobo.scala

import scala.collection.immutable.HashSet
import scala.io.Source

/**
  * Created by bobo on 2017/6/29.
  */
object Var {
  def main(args: Array[String]): Unit = {

    var onw = 1 :: 2 :: 3 :: Nil
    var pare = ("aaa", 4)
    var set = HashSet("bobo", "ggg")
    print(set)
    var treemap = Map[Int, String]()
    treemap += (1 -> "go to.")
    treemap += (2 -> "find")
    treemap += (3 -> "ggg")
    println(treemap)
    println(treemap(3))

    val noMap = Map[Int, String](1 -> "geeg", 2 -> "hhhh")
    println(noMap(1))

    def printArg(args: Array[String]): Unit = {
      for (arg <- args) {
        println(arg)
      }
    }

    printArg(Array("11", "333"))

    def format(args: Array[String]) = args.mkString("+")

    println(format(Array("555", "7777")))

    def ut() = {"this is not"}
    print(ut())
  }
}
