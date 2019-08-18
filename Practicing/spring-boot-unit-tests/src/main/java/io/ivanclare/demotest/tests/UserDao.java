package io.ivanclare.demotest.tests;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
   public String getUser() {
	   
       return "Tom";
   }
   
}
