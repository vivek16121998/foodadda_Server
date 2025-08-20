package com.infy.api;



import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.ai.chat.client.ChatClient;

import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;

import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.ResponseDTO;


@RestController
@RequestMapping("/AgentAPI")
@CrossOrigin
public class AgentController {
	
	private final ChatClient chatClient;
	
	private final Map<String,PromptChatMemoryAdvisor> advisorMap = new ConcurrentHashMap<String,PromptChatMemoryAdvisor>();
	
	
	

	public AgentController(ChatClient chatClient) {
		
		this.chatClient = chatClient;
	}
	
	
	
	@GetMapping("/{sessionId}/{input}")
	ResponseEntity<ResponseDTO> invokeAgent(@PathVariable String sessionId ,@PathVariable String input) {
		// Fetch Session ID
       
		
        var advisor=this.advisorMap.
        		computeIfAbsent(sessionId, i-> PromptChatMemoryAdvisor.builder(MessageWindowChatMemory.builder()
    		    .build()).build());
        
        String message= this.chatClient
			    .prompt()
			    .user(input)
			    .advisors(advisor)
			    .call()
			    .content();
        ResponseDTO response = new ResponseDTO();
        response.setResponse(message);
        return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	

}
