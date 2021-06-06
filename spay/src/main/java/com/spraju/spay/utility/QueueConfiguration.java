package com.spraju.spay.utility;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfiguration {
	public static final String topicExchangeName = "message_queue_exchange";

	public static final String queueName = "message_queue";
	

	@Bean
	Queue queue()
	{
		return new Queue(queueName, false);
	}

	@Bean
	TopicExchange exchange()
	{
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange)
	{
		return BindingBuilder.bind(queue).to(exchange).with("message_routing_key");
	}
	
	 @Bean
	    public MessageConverter messageConverter() {
	        return  new Jackson2JsonMessageConverter();
	    }
	 
	 @Bean
	    public AmqpTemplate template(ConnectionFactory connectionFactory) {
	        RabbitTemplate template = new RabbitTemplate(connectionFactory);
	        template.setMessageConverter(messageConverter());
	        return  template;
	    }
}
