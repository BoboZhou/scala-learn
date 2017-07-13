package com.bobo.scala

/**
  * Created by bobo on 2017/6/30.
  */
class CheckSu {
  private val cache = Map[String, Int]()

  def calculate(s: String): Unit = {
    if (cache.contains(s))
      cache(s)
    else {
      val avv = new CheckSu()
      for (c <- s)
        println(s)
    }


  }

}
