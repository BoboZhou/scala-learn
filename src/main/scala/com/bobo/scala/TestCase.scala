package com.bobo.scala

/**
  * Created by bobo on 2017/7/5.
  */
case class TestCase(private var offset: Long) {

  def getLong(): Long = {
    offset
  }
}
