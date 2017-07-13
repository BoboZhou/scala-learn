package com.bobo.scala

object VariableDemo {
  def main(args: Array[String]) {
    var onetow = List(1, 2)
    var treeFor = List(3, 4)
    println(1 :: onetow)
    println(onetow :: treeFor)
    printarg(Array(1, 2, 3, 4))
  }

  def max(x: Int, y: Int): Int = {
    if (x > y)
      x
    else y

  }

  println("nnidhfak")

  def md(x: Int, y: Int) = if (x > 1) x else y

  def printarg(args: Array[Int]): Unit = {
    for (arg <- args) {
      println(arg)
    }
  }
}