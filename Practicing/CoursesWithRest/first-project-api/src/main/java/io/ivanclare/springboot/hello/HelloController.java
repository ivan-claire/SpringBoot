package io.ivanclare.springboot.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //have a methods that maps to a url request
public class HelloController {
   
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}
}


