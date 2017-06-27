package org.hrd.spring.services.impl;



import java.util.List;

import org.hrd.spring.model.User;
import org.hrd.spring.repositories.UserRepository;
import org.hrd.spring.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServices {
	
	private UserRepository userRepository;

	
	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository= userRepository;
		
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public boolean save(User user) {
		return userRepository.saveUser(user);
	}

	@Override
	public boolean deleteUserByHashCode(String hashCode) {
		return userRepository.deleteUserByHashCode(hashCode);
	}

	@Override
	public User findUserByHash(String userHash) {
		return userRepository.findUserByHash(userHash);
	}

	@Override
	public boolean updateUser(User user) {
		return userRepository.update(user);
	}

	@Override
	public boolean userCountMale(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> countman() {
		
		return userRepository.countman();
	}

	@Override
	public List<User> countfemale() {
		return userRepository.countfemale();
	}

	

	
	
	
	
	
}
