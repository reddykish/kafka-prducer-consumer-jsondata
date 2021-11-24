package com.kafka.consumer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	@KafkaListener(topics = "Employee", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
	public void consumeUserMessage(@Payload Employee msg, @Headers MessageHeaders headers) throws IOException {
	    System.out.println("received data in Consumer One ="+ msg);
	
}
}
