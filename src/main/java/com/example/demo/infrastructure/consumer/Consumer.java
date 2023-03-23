package com.example.demo.infrastructure.consumer;

import com.example.demo.application.CompraSave;
import com.example.demo.domain.entities.Compra;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Log4j2
public class Consumer {
  private final ObjectMapper objectMapper;
  private final CompraSave compraSave;

  @RabbitListener(queues = "${Compra.queue.compra}")
  public void consume(Message message) throws JsonProcessingException {
    String jason = new String(message.getBody(), StandardCharsets.UTF_8);
    String httpMethod = message.getMessageProperties().getHeader("HTTP_METHOD");
    log.info("Received HTTP method: {}", httpMethod);
    Compra compra = objectMapper.readValue(jason, Compra.class);
    compraSave.saveCompra(compra);
  }


}
