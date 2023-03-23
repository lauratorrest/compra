package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;

public class RabbitMqConfig {
  public static final String EXCHANGE_NAME = "topictest";
  public static final String ROUTING_KEY = "routing_key";
  private static final String QUEUE_NAME = "prueba";
  private static final boolean IS_DURABLE_QUEUE = false;

  @Bean
  Queue queue(){return new Queue(QUEUE_NAME,IS_DURABLE_QUEUE);}

  @Bean
  TopicExchange exchange(){return new TopicExchange(EXCHANGE_NAME);}

  @Bean
  Binding binding(Queue queue , TopicExchange exchange){
    return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
  }
}
