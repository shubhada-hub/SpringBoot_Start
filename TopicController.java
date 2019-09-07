package com.practice.springboot.topic.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springboot.topic.Topic;
import com.practice.springboot.topic.service.TopicServices;
import com.practice.springboot.topic.validation.TopicValidation;

@RestController
public class TopicController {
	
	@Autowired
	private TopicServices services;
	@Autowired
	TopicValidation validate;
	
	@GetMapping(value="/topics")
	public List<Topic>getTopics(){
		return services.getTopics();
	}
	
	@GetMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id){
		return services.getTopic(id);
	}
	
	@PostMapping(value="/topics")
	public ResponseEntity<?> addTopics(@Valid @RequestBody Topic topic,Errors error){
		
		validate.validate(topic, error);
		if(error.hasErrors()){
			return new ResponseEntity<>(createErrorString(error),HttpStatus.BAD_REQUEST);
		}else{
		services.addTopics(topic);
		return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	private String createErrorString(Errors errors) {
        return errors.getAllErrors().stream().map(ObjectError::toString).collect(Collectors.joining(","));
    }

}
