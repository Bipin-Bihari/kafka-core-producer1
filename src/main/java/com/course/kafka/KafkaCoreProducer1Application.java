package com.course.kafka;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.kafka.producer.KafkaKeyProducer;

@SpringBootApplication
public class KafkaCoreProducer1Application implements CommandLineRunner{
	@Autowired
    private KafkaKeyProducer producer;
	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducer1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=0;i<=10_000;i++) {
			var key="key-"+i%4;
			var value="value "+i+ " with key " +key;
			producer.send(key, value);
			TimeUnit.SECONDS.sleep(1);
		}		
	}

}
