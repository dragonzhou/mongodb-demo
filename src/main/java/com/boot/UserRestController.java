package com.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
// @SpringBootApplication
public class UserRestController {

	@Autowired
	private UserRepository	userRepository;

	@RequestMapping("")
	public List<User> view() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@RequestMapping("{id}")
	public User view(@PathVariable("id") Integer id) {
		User user = userRepository.findUserById(id);
		return user;
	}


}
