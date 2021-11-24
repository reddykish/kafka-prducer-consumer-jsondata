package com.kafka.api;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.Producerconfig;

@RestController
public class Webservice {
	
	@Autowired
	Producerconfig producerconfig;
	
	@PostMapping(value="add",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addObjectData(@RequestBody Employee message)
	{
		KafkaProducer<String,Object> producer=producerconfig.producerJson();
		producer.send(new ProducerRecord<String,Object>("Employee",message));
		return "Updated-json";
	}
	
	
	@PostMapping(value="addstring",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addStringData(@RequestBody String message)
	{
		KafkaProducer<String,String> producer=producerconfig.producerString();
		producer.send(new ProducerRecord<String,String>("Employee",message));
		return "Updated-String";
	}
	
	

}

