package com.cg.capstore.service;

import com.cg.capstore.dto.Login;
import com.cg.capstore.dto.User;

public interface IUserService {

	public User signUp(User user);

	public User userLogin(Login login);

	public User getUserName(String userName);
	
	public User getUserByUserId(int userId);
	
	public User updateUser(User user);
	
	public String forgetPassword(String userName);

}
