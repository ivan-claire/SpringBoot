package io.ivanclare.demotest.tests;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
   @Resource
   private UserDao userDao;

   public String getUser() {
       return userDao.getUser();
   }
   
}
