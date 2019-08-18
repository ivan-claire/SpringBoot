package io.ivanclare.springboot.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
    private CourseRepository courseRepository;

	/*private List<Course> courses = new ArrayList<>(Arrays.asList(
			new Course("IAAS", "Cloud Computing","Infrastructure As A Service"),
			new Course("PAAS", "Cloud Computing","Platform As A Service"),
			new Course("SAAS", "Cloud Computing","Software As A Service")
			));*/
	
	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		//courseRepository.findByName(course);
		return courseRepository.findById(id).get();
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
