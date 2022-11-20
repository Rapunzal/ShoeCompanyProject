package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.User;
import com.simplilearn.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUser(){
		List<User> user=new ArrayList<User>();
		userRepository.findAll().forEach(u->user.add(u));
		return user;
	} 
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public List<User> getAllUserByFirstName(String firstName){
		List<User> user=new ArrayList<User>();
		user=userRepository.findAllByFirstName(firstName);
		return user;
	}
	
	public Optional<User> getUserById(int id) {
		Optional<User> user=userRepository.findById(id);
		return user;
	}
	
	public User getUserByEmailIdAndPassword(String emailId,String password){
		//List<User> user=new ArrayList<User>();
		User user=userRepository.findByemailIdAndPassword(emailId, password);
		return user;
	}
}
