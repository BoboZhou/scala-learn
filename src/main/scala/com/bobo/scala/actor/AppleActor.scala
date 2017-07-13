package com.bobo.scala.actor

import scala.actors.Actor

/**
  * Created by bobo on 2017/7/13.
  */
case class SyncMsg(id: Int, msg: String)

case class AsyncMsg(id: Int, msg: String)

case class ReplyMsg(id: Int, msg: String)

object AppleActor {
  def main(args: Array[String]) {
    val a = new AppleActor
    a.start()
    //异步消息
    a ! AsyncMsg(1, "hello actor")
    println("异步消息发送完成")
    //同步消息
    //val content = a.!?(1000, SyncMsg(2, "hello actor"))
    //println(content)
    val reply = a !! SyncMsg(2, "hello actor")
    println(reply.isSet)
    //println("123")
    val c = reply.apply()
    println(reply.isSet)
    println(c)
  }

  class AppleActor extends Actor {
    override def act(): Unit = {
      while (true) {
        receive {
          case "start" => println("starting....")
          case SyncMsg(id, msg) => {
            println(id + ",sync " + msg)
            Thread.sleep(5000)
            sender ! ReplyMsg(3, "finished")
          }
          case AsyncMsg(id, msg) => {
            println(id + ",async " + msg)
            Thread.sleep(5000)
          }

        }
      }
    }
  }

}
