package io.ivanclare.springboot.courses;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.ivanclare.springboot.topics.Topic;

@RestController 
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		
		return courseService.getAllCourses(topicId);	
	}
	
	@RequestMapping("/topics/{topicid}/courses/{courseid}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicid}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicid}/courses/{courseid}")
	public void updateCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicid}/courses/{courseid}")
	public void deleteCourse(@RequestBody Course course,@PathVariable String courseid) {
		courseService.deleteCourse(courseid);
	}

}
