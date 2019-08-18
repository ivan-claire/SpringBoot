package io.ivanclare.springboot.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
    private TopicRepository topicRepository;

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("IAAS", "Cloud Computing","Infrastructure As A Service"),
			new Topic("PAAS", "Cloud Computing","Platform As A Service"),
			new Topic("SAAS", "Cloud Computing","Software As A Service")
			));
	
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topicRepository.findById(id).get();
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
	}

	public void deleteTopic(Topic topic, String id) {
		topicRepository.deleteById(id);
	}
}
