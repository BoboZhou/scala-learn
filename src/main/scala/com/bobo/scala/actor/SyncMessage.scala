package com.bobo.scala.actor

import scala.actors.Actor

/**
  * Created by bobo on 2017/7/13.
  */
case class SyncMes(id: Int, msg: String)

case class AsyncMsg(id: Int, msg: String)

case class ReplyMsg(id: Int, msg: String)

object AppleActorMsg {
  def main(args: Array[String]): Unit = {
    val a = new SyncMessage
    a.start()
    //异步消息
    val k = a !! AsyncMsg(1, "syncmsg")
    val apply = k.apply()
    println(k.isSet)
    val rep = apply.asInstanceOf[ReplyMsg]
    println(rep.msg)
    //异步消息没有返回值
    a ! AsyncMsg(2, "synMsgWout")
    //同步消息
    val t = a !? SyncMes(3, "syncmsg")
    val replyMsg = t.asInstanceOf[ReplyMsg]
    println(replyMsg.msg)
  }
}

class SyncMessage extends Actor {
  override def act(): Unit = {
    while (true) {
      receive {
        case "start" => println("starting...")
        case SyncMes(id, msg) => {
          println(id + ",sync" + msg)
          Thread.sleep(3000)
          sender ! ReplyMsg(id, "finshed")
        }
        case AsyncMsg(id, msg) => {
          println(id + ",async" + msg)
          sender ! ReplyMsg(id, "finshed")
        }
      }
    }
  }
}
