package com.practice.springboot.topic.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.springboot.topic.Topic;
import com.practice.springboot.topic.repository.TopicRepository;

@Service
public class TopicServices {
	
	@Autowired
	public TopicRepository topicRepository;

	/*private List<Topic> topics = new ArrayList<>( Arrays.asList(
			new Topic("1","spring","spring boot"),
			new Topic("2","java","java api"),
			new Topic("3","angular","angular js")
));*/
	
	public List<Topic> getTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id){
		return topicRepository.findOne(id);
	}

	public void addTopics(Topic topic) {
		
		//topics.add(topic);
		topicRepository.save(topic);
		
	}

	/*public void updateTopics(Topic topic, String id) {
		for(int i=0;i<topics.size();i++){
			if(topics.get(i).getId().equalsIgnoreCase(id)){
				topics.set(i, topic);
			}
		}
	}*/
	
}
