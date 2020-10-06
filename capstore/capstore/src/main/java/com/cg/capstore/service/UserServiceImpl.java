package com.cg.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.capstore.dto.Login;
import com.cg.capstore.dto.User;
import com.cg.capstore.exception.UserNotFoundException;
import com.cg.capstore.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	/**
	 * @param user return user
	 */

	@Override
	public User signUp(User user) {

		List<String> allUsername = userRepository.getAllUsername();
		List<String> allEmailId = userRepository.getAllUserEmailId();

		for (String usernames : allUsername) {
			if (usernames.equals(user.getUserName())) {
				throw new UserNotFoundException(user.getUserName() + " Username is already used.");
			}

		}
		for (String emailIds : allEmailId) {
			if (emailIds.equals(user.getEmailId())) {
				throw new UserNotFoundException("EmailId is already used.");
			}
		}
		return userRepository.save(user);
	}

	/***
	 * @param user
	 * 
	 *             return login status
	 * 
	 */

	@Override
	public User userLogin(Login login) {

		User getUser = userRepository.findUserByUserName(login.getUserName());
		if (getUser == null) {
			throw new UserNotFoundException("Incorrect Username or Password ");
		} else {
			if ((getUser.getUserName().equals(login.getUserName()))
					&& (getUser.getPassword().equals(login.getPassword()))) {

				return getUser;
			} else {
				throw new UserNotFoundException("Incorrect Username or Password ");
			}

		}

	}

	/**
	 * 
	 * @param userName return User
	 * 
	 */

	@Override
	public User getUserName(String userName) {

		User user = userRepository.findUserByUserName(userName);
		return user;
	}

	@Override
	public User getUserByUserId(int userId) {
		User user = userRepository.findById(userId).get();
		if (user == null) {
			throw new UserNotFoundException("User not found with given Id-> " + userId);
		}
		return user;
	}

	@Override
	public User updateUser(User user) {

		User existingUser = userRepository.findById(user.getUserId()).get();
		if (existingUser == null) {
			throw new UserNotFoundException("User not found with given Id-> " + user.getUserId());
		}
		existingUser.setContactNo(user.getContactNo());
		existingUser.setUserName(user.getUserName());

		return existingUser;
	}

}
