package se.redbridge.academy.serverless;

import com.kumuluz.ee.amqp.common.annotations.AMQPProducer;
import com.kumuluz.ee.amqp.rabbitmq.utils.producer.Message;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RMQ {
  @AMQPProducer(host = "mqtest", key = "test")
  public Message sendThisMessage(String message) {
    final var msg = new Message();
    msg.body(message);

    return msg;
  }
}
