package com.bobo.scala.common

import scala.collection.mutable.ArrayBuffer

/**
  * Created by bobo on 2017/7/13.
  */
class Session {

}

object SessionFactory {
  var count = 5;
  val session = new ArrayBuffer[Session](5)
  while (count > 0) {
    session += new Session
    count -= 1
  }

  def getSession(): Session = {
    session.remove(0)
  }
}
object SingletonDemo {
  def main(args: Array[String]) {
    //单例对象，不需要new，用【类名.方法】调用对象中的方法
    val session = SessionFactory.getSession()
    println(session)
  }
}

