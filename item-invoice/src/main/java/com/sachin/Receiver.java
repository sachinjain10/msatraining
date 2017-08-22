package com.sachin;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@KafkaListener(topics = "${kafka.topic.helloworld}", containerFactory = "kafkaListenerContainerFactory")
	public void receive(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
		//LOGGER.info("received message='{}' on partition {}", message, partition);
		System.out.println("received message='{}' on partition {}" +message + partition);
		//latch.countDown();
	}

	@KafkaListener(topics = "${kafka.topic.helloworld}", containerFactory = "filterKafkaListenerContainerFactory")
	public void receiveFiltered(String message) {
		//LOGGER.info("received filtered message='{}'", message);
		System.out.println("received message='{}' on partition {}" +message );
		//filteredLatch.countDown();
	}

}
