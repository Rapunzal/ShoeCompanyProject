package com.simplilearn.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findAllByFirstName(String firstName);
	
	public User findByemailIdAndPassword(String emailid,String password);
	
	
}
