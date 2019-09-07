package com.practice.springboot.topic.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.practice.springboot.topic.Topic;

@Component
public class TopicValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Topic.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors error) {
		// TODO Auto-generated method stub
		Topic topic =(Topic)obj;
		ValidationUtils.rejectIfEmpty(error, "description", "description can no be empty");
	}

}
