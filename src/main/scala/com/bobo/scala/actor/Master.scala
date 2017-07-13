package com.bobo.scala.actor

import akka.actor.Actor
import akka.actor.Actor.Receive

/**
  * Master为整个集群中的主节点
  * Master继承了Actor

  */
class Master extends Actor{
  override def receive: Receive = ???
}
