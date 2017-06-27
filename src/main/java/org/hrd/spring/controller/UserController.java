package org.hrd.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hrd.spring.model.User;
import org.hrd.spring.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	private UserServices userService;
	@Autowired
	public UserController(UserServices userService){
		this.userService=userService;
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model){
		List<User> listuser=new ArrayList<>();
		List<User> listman=new ArrayList<>();
		List<User> listfemle=new ArrayList<>();
		
		listuser=userService.findAll();
		listman=userService.countman();
		listfemle=userService.countfemale();
		
		model.addAttribute("TOTAL",listuser.size());
		model.addAttribute("CM",listman.size());
		model.addAttribute("CF",listfemle.size());
		return "/admin/dashboard";
	}
	@RequestMapping("/user-list")
	public String userList(ModelMap map){
		map.put("USER", userService.findAll());
		return "/admin/user-list";
	}
	
	@RequestMapping("/user-cu")
	public String userCU(ModelMap model){
		model.put("USER", new User());
		model.put("ACTION", "/add-user");
		return ("/admin/user-cu");
	}
	
	@RequestMapping("/user-update-form/{userHash}")
	public String userUpdateForm(@PathVariable("userHash") String userHash, ModelMap model){
		model.put("USER", userService.findUserByHash(userHash));
		model.put("ACTION", "/update-user");
		return ("/admin/user-cu");
	}
	
	@RequestMapping("/role-list")
	public String roleList(){
		return ("/admin/role-list");
	}
	
	@RequestMapping("/role-cu")
	public String roleCU(){
		
		return ("/admin/role-cu");
	}
	
	@RequestMapping("/add-user")
	public String addUser(@ModelAttribute User user){
		String uuid = UUID.randomUUID().toString();
		user.setUser_hash(uuid);
		userService.save(user);
		return "redirect:/user-list";
	}
	
	@RequestMapping("/delete-user/{userHash}")
	public String deleteUserByHashCode(@PathVariable("userHash") String userHash){
		userService.deleteUserByHashCode(userHash);
		return "redirect:/user-list";
	}
	
	@PostMapping("/update-user")
	public String updateUserByHashCode(@ModelAttribute("user") User user, ModelMap map){
	userService.updateUser(user);
	map.put("USER", userService.findAll());
	return "redirect:/user-list";
	}
	
	@RequestMapping("/user-detail/{userHash}")
	public String userDetail(@PathVariable("userHash") String userHash, ModelMap map){
		map.put("USER", userService.findUserByHash(userHash));
		map.put("URL", "/admin/user-detail/"+userHash);
		return "/admin/user-detail";
	}
	
}
	
