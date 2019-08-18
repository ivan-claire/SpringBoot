package io.ivanclare.demotest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.ivanclare.demotest.tests.UserService;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class) // @RunWith: integrate spring with junit
@SpringBootTest(classes = {SpringBootUnitTestsApplication.class}) // @SpringBootTest: this class is spring boot test.
public class UserServiceTest {
	
   @Resource
   private UserService userService;

   @Test
   public void testGetUser() {
       Assert.assertEquals(userService.getUser(), "Tom");
   }
}
