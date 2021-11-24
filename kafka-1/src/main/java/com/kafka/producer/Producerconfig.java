package com.kafka.producer;


import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

@Component
public class Producerconfig {

	public KafkaProducer<String,Object> producerJson()
	{
	Properties configs = new Properties();
	configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	KafkaProducer<String,Object> producer=new KafkaProducer<String,Object>(configs);
	 return producer;
	}
	
	public KafkaProducer<String,String> producerString()
	{
	Properties configs = new Properties();
	configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	KafkaProducer<String,String> producer=new KafkaProducer<String,String>(configs);
	 return producer;
	}
}
