package com.cg.capstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.capstore.dto.User;

/**
 * Repository for storing user details.
 * 
 * @author sameer mandavia
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT user FROM User user WHERE user.userName=:userName")
	public User findUserByUserName(String userName);

	@Modifying()
	@Query("UPDATE User u SET u.walletAmount = u.walletAmount + ?1 WHERE u.userId =?2")
	int updateWalletAmount(double walletAmount,int userId);
	
	@Modifying()
	@Query("UPDATE User u SET u.walletAmount = ?1 WHERE u.userId =?2")
	int deductWallet(double walletAmount,int userId);
	
	@Query("SELECT user.userName FROM User user")
	public List<String> getAllUsername();
	
	@Query("SELECT user.emailId FROM User user")
	public List<String> getAllUserEmailId();
	
	@Query("SELECT user.password FROM User user WHERE user.userName= :username")
	public String getUserPassword(String username);
	

}
