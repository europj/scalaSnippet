package concurrency.akka.simpleIO

import akka.actor.{Actor, Props}
import concurrency.akka.simpleIO.GreetingActor.{GreetResp, GreetingReq}

object GreetingActor {
  def props():Props = Props(new GreetingActor)

  case class GreetingReq(value: String)
  case class GreetResp(value: String)
}

class GreetingActor extends Actor {
  override def receive: Receive = {
    case GreetingReq(v) => sender() ! GreetResp(s"hello, your result is $v")
  }
}
