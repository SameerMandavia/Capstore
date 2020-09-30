package com.cg.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.dto.Login;
import com.cg.capstore.dto.User;
import com.cg.capstore.exception.UserNotFoundException;
import com.cg.capstore.service.UserServiceImpl;

/**
 * @author sameer mandavia
 *
 *         Controller class
 *
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/capstore")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	


	/***
	 * *
	 * 
	 * @param user
	 * @return
	 */

	@PostMapping(value = "/signUp")
	public User signUp(@RequestBody User user) {
		return userService.signUp(user);

	}

	/***
	 * 
	 * @param userName
	 * @return
	 */

	@GetMapping(value = "/getUserName/{userName}")
	public User getUserName(@PathVariable String userName) {
		User user = userService.getUserName(userName);
		return user;
	}

	/***
	 * *
	 * 
	 * @param user
	 * @return
	 */

	@PostMapping(value = "/login")
	public User userLogin(@RequestBody Login login) {
		return userService.userLogin(login);
	}
	
	@GetMapping(value="/getUserByUserId/{userId}")
	public User getUserByUserId(@PathVariable int userId) {
		
		return userService.getUserByUserId(userId);
	}

	@PutMapping(value="/updateUser")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
}
