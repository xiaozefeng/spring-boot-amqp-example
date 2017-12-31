package com.gz.springbootamqpexample;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author xiaozefeng
 */
@SpringBootApplication
public class SpringBootAmqpExampleApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAmqpExampleApplication.class, args);
	}

	/**
	 * Spring boot 为我们定义好的RabbitTemplate
	 */
	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * 定义队列
	 * @return
	 */
	@Bean
	public Queue stevenQueue(){
		return new Queue("my-queue");
	}

	/**
	 * 通过 RabbitTemplate 向队列 my-queue 发送消息
	 * @param strings
	 * @throws Exception
	 */
	@Override
	public void run(String... strings) throws Exception {
		rabbitTemplate.convertAndSend("my-queue", "来自RabbitMQ的问候");
	}
}
