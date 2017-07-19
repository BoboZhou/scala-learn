package com.bobo.scala.actor

import java.io.File

import scala.actors.{Actor, Future}
import scala.collection.mutable
import scala.io.Source

/**
  * Created by bobo on 2017/7/13.
  */
case class SubmitTask(fileName: String)

case class StopTask()

case class ResultCalss(result: Map[String, Int])

class Task extends Actor {
  override def act(): Unit = {
    loop {
      react {
        case SubmitTask(fileName) => {
          val file = Source.fromFile(new File(fileName)).mkString
          val arr = file.split("\r\n")
          val result = arr.flatMap(_.split(" "))
          val values = result.map((_, 1))
          val by = values.groupBy(_._1)
          val maybeTuples = by.get("tom").get
          println(
            maybeTuples
          )
          println()

          val mapValues = by.mapValues(_.length)
          sender ! ResultCalss(mapValues)

        }
        case StopTask => {
          exit()
        }

      }
    }
  }
}

object WorkCount {
  def main(args: Array[String]) {
    val files = Array("d://words.txt", "d://words.log")

    val replaySet = new mutable.HashSet[Future[Any]]
    val resultList = new mutable.ListBuffer[ResultCalss]

    for (f <- files) {
      val t = new Task
      val replay = t.start() !! SubmitTask(f)
      replaySet += replay
    }

    while (replaySet.size > 0) {
      val toCumpute = replaySet.filter(_.isSet)
      for (r <- toCumpute) {
        val result = r.apply()
        resultList += result.asInstanceOf[ResultCalss]
        replaySet.remove(r)
      }
      Thread.sleep(100)
    }
    val finalResult = resultList.map(_.result).flatten.groupBy(_._1).mapValues(x => x.foldLeft(0)(_ + _._2))
    println(finalResult)
  }
}

