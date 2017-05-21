package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTests {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	private UserService userService;
	@Test
	public void userTestAdd() throws Exception{
		User testUser=new User();
		testUser.setName("John");
		testUser.setPassword("pass1235");
		int count=jdbcTemplate.queryForObject("select count(*) from users",Integer.class);
		userService.add(testUser);
		int countAdd=jdbcTemplate.queryForObject("select count(*) from users",Integer.class);
		Assert.assertEquals(count+1,countAdd);
		userService.delete(testUser);
		Assert.assertEquals(countAdd-1,count);
	}
	@Test
	public void userTestUpdate() throws Exception{
		User testUser=new User();
		testUser.setName("Mike");
		testUser.setPassword("pass1235");
		int firstId=userService.add(testUser).getId();
		User testUser2=new User();
		testUser2.setId(firstId);
		testUser2.setName("James");
		testUser2.setPassword("pass435");
		userService.update(testUser2);
		int secondId=jdbcTemplate.queryForObject("select id from users where name=?",Integer.class,testUser2.getName());
		Assert.assertEquals(testUser.getId(),secondId);
		userService.delete(testUser2);

	}
}