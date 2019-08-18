package io.ivanclare.springboot.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("IAAS", "Cloud Computing","Infrastructure As A Service"),
			new Topic("PAAS", "Cloud Computing","Platform As A Service"),
			new Topic("SAAS", "Cloud Computing","Software As A Service")
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
				
		}
		
	}

	public void deleteTopic(Topic topic, String id) {
		topics.removeIf(t -> t.getId().equals(id));
		
	}
}
