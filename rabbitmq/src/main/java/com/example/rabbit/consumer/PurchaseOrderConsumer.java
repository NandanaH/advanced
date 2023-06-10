package com.example.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.rabbit.config.MessagingConfig;
import com.example.rabbit.model.OrderStatus;

@Component
public class PurchaseOrderConsumer {
	@Value("${ust.rabbitmq.queue}")
	String queueName;
	@Value("${ust.rabbitmq.exchange}")
	public
	String exchange;
	@Value("{ust.rabbitmq.routingkey}")
	public String routingkey;
	

	@RabbitListener(queues= "ust_queue")
	public void consumeMessageFromQueue(OrderStatus orderStatus) {
		System.out.println("Message received from queue:"+ orderStatus);
	}
}
