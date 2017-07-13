package com.bobo.scala

/**
  * Created by bobo on 2017/6/30.
  */
class Rat(n: Int, d: Int) {
  require(d != 0)
  println("Create " + n + "/" + d)
  val number :Int = n
  val denom:Int = d
  def  this(n:Int) = this(n,1)
  def add(that:Rat):Rat={
    new Rat(
      number*that.denom+that.number*denom,
      denom*that.denom
    )
  }
  override def toString: String = n + "/" + d

  def main(args: Array[String]): Unit = {
     val rat = new Rat(1,0)

  }

}
