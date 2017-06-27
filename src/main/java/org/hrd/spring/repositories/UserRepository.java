package org.hrd.spring.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.hrd.spring.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	@Select("SELECT"
			+ " id,"
			+ " username, "
			+ " gender, "
			+ " email, "
			+ " phonenumber, "
			+ " status, "
			+ " user_hash "
			+ "	FROM users")
	
	public List<User> findAll();
	
	@Insert("INSERT INTO users(username,gender,email,phonenumber,status,user_hash)"
			+ " VALUES (#{user.username}, #{user.gender},#{user.email}, #{user.phonenumber},#{user.status},#{user.user_hash});")
	public boolean saveUser(@Param("user") User user);
	

	@Delete("DELETE FROM users WHERE user_hash=#{hashCode}")
	public boolean deleteUserByHashCode(@Param("hashCode")String hashCode);
	
	@Select("SELECT"
			+ " id,"
			+ " username, "
			+ " gender, "
			+ " email, "
			+ " phonenumber, "
			+ " status, "
			+ " user_hash "
			+ "	FROM users WHERE user_hash=#{userHash}")
	public User findUserByHash(@Param("userHash") String userHash);
	
	@Update("UPDATE users SET "
			+ "username=#{user.username},"
			+ "gender=#{user.gender},"
			+ "email=#{user.email},"
			+ "phonenumber=#{user.phonenumber},"
			+ "status=#{user.status} "
			+ " WHERE user_hash=#{user.user_hash}")
	public boolean update(@Param("user") User user);
	
	
	/*@Select("SELECT COUNT(gender)"
			+ "from users WHERE gender='Male',"
			+ "GROUP BY id")
	public boolean userDetail(@Param("user") User user);*/
	
	@Select("SELECT"
			+ " id,"
			+ " username, "
			+ " gender, "
			+ " email, "
			+ " phonenumber, "
			+ " status, "
			+ " user_hash "
			+ "	FROM users WHERE gender='Male'")
	
	public List<User> countman();
	
	@Select("SELECT"
			+ " id,"
			+ " username, "
			+ " gender, "
			+ " email, "
			+ " phonenumber, "
			+ " status, "
			+ " user_hash "
			+ "	FROM users WHERE gender='Female'")
	
	public List<User> countfemale();
	
}
