package com.example.rabbit.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbit.config.MessagingConfig;
import com.example.rabbit.model.OrderStatus;
import com.example.rabbit.model.PurchaseOrder;



@RestController
@RequestMapping("/order")
public class PurchaseOrderPublisher {
	
	@Value("${ust.rabbitmq.queue}")
	String queueName;
	@Value("${ust.rabbitmq.exchange}")
	public
	String exchange;
	@Value("{ust.rabbitmq.routingkey}")
	public String routingkey;
	
	
	@Autowired
	private RabbitTemplate template;
	@PostMapping("/{customerName}")
	public String bookOrder(@RequestBody PurchaseOrder order, @PathVariable String customerName ) {
		order.setOrderId(UUID.randomUUID().toString());
		OrderStatus orderStatus = new OrderStatus(order,"ACCEPTED","order placed successfully by"+customerName);
//		template.convertAndSend(MessagingConfig.exchange,MessagingConfig.routingkey,orderStatus);
		template.convertAndSend(exchange,routingkey,orderStatus);
		return "Success";
	}

}
