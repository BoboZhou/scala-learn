package com.bobo.scala.actor

import scala.actors.Actor

/**
  * Created by bobo on 2017/7/13.
  */
class MyActor extends Actor {
  override def act(): Unit = {
    while (true) {

      receive {
        case "start" => {
          println("starting ...")
          Thread.sleep(5000)
          println("started")
        }
        case "stop" => {
          println("stopping ...")
          Thread.sleep(5000)
          println("stopped ...")
        }
      }

    }
  }
}

object MyActor {
  def main(args: Array[String]) {
    val actor = new MyActor
    actor.start()
    actor ! "start"
    actor ! "stop"
    println("消息发送完成！")
  }
}

