package org.hrd.spring.services;



import java.util.List;

import org.hrd.spring.model.User;


public interface UserServices {
	public List<User> findAll();
	public boolean save(User user);
	public boolean deleteUserByHashCode(String hashCode);
	public boolean updateUser(User user);
	public boolean userCountMale(User user);
	public User findUserByHash(String userHash);
	public List<User> countman();
	public List<User> countfemale();
	
}
