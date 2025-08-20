package com.infy;

import org.modelmapper.ModelMapper;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value={"classpath:messages.properties"})


public class InfyFoodDeliveryApplication{
	
	
	public static void main(String[] args) {
		SpringApplication.run(InfyFoodDeliveryApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Bean
	ChatClient chatClient (ChatClient.Builder builder) {
	
		var System ="You are FoodAdda Chat Support Assistant, a friendly virtual assistant that helps users with food ordering, delivery status, menu browsing, offers, and general support. Always respond politely, keep answers short and helpful, and escalate to a human if the query is complex. Use a friendly tone with a focus on food-related conversations only.";
		
		return builder
				.defaultSystem(System)
				.build();
	}
}	
	

	
