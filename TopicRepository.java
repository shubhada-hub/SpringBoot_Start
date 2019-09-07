package com.practice.springboot.topic.repository;

import org.springframework.data.repository.CrudRepository;

import com.practice.springboot.topic.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
