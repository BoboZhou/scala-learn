package com.bobo.scala.actor

import scala.actors.Actor

/**
  * Created by bobo on 2017/7/13.
  */
case class SyncMsgq(id: Int, msg: String)

case class AsyncMsgq(id: Int, msg: String)

case class ReplyMsgq(id: Int, msg: String)

object AppleActor {
  def main(args: Array[String]) {
    val a = new AppleActor
    a.start()
    //异步消息
    a ! AsyncMsgq(1, "hello actor")
    println("异步消息发送完成")
    //同步消息
    //val content = a.!?(1000, SyncMsg(2, "hello actor"))
    //println(content)
    val reply = a !! SyncMsgq(2, "hello actor")
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
          case SyncMsgq(id, msg) => {
            println(id + ",sync " + msg)
            Thread.sleep(5000)
            sender ! ReplyMsgq(3, "finished")
          }
          case AsyncMsgq(id, msg) => {
            println(id + ",async " + msg)
            Thread.sleep(5000)
          }

        }
      }
    }
  }

}
