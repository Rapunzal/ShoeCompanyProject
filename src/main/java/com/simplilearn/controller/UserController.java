package com.simplilearn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.entity.User;
import com.simplilearn.service.UserService;

@Controller
@RequestMapping("/company")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/user")
	public String getAllUser(Model model) {
		List<User> user=userService.getAllUser();
		model.addAttribute("user", user);
		return "user";
	}
	
	@GetMapping("/addUser")
	public String addUser(Model model) {
		User user=new User();
		model.addAttribute("user", user);
		return "addUser";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user ) {
		userService.saveUser(user);
		System.out.println(user.getFirstName());
		return "redirect:/company/user";
	}
	
	@GetMapping("/search")
	public String searchUserByFirstName(@RequestParam("firstName") String firstName,Model model) {
		List<User> user=userService.getAllUserByFirstName(firstName);
		System.out.println(firstName);
		model.addAttribute("theUser", user);
		return "searchUser";
	}
	
	@GetMapping("/adminform")
	public String adminform(Model model) 
	{
		User user=new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("emailId")String emailId,@RequestParam("password")String password,Model model) {
		User user=userService.getUserByEmailIdAndPassword(emailId, password);
	
		//System.out.println(user.getFirstName());
		if(user==null) {
			model.addAttribute("msg","Username or password is incorrect");
			return "redirect:/company/adminform";
		}
			model.addAttribute("user", user);
			return "hello";
	}
	
	@PostMapping("/changePasswordForm")
	public String changePasswordForm(@RequestParam("userId")String id,Model model) {
		User user=new User();
		model.addAttribute("id", id);
		System.out.println("user id--->"+id);
		return "changePassword";
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestParam("password")String oldPassword,@RequestParam("newpassword")String newPassword,@ModelAttribute("id") String id) {
		System.out.println("id-------->"+id);
		int i=Integer.parseInt(id);
		System.out.println("i======>"+i);
		Optional<User> user=userService.getUserById(i);
		System.out.println("user===="+user);
		User user1=user.orElse(null);
		user1.setPassword(newPassword);
		System.out.println("Password "+user1.getPassword());
		userService.saveUser(user1);
		
		//userService.getUserById();
		//userService.saveUser(user);
		return "redirect:/company/user";
	}
	
	
	
	
}
