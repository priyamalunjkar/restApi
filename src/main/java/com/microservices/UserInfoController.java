package com.microservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

	@Autowired
	UserInfoRepos userInfoRepos;

	@GetMapping("/getName")
	public String getName() {
		return "Priya";
	}

	@PostMapping("/addUserInfo")
	public void addUserInfo(@RequestBody User userInfo) {
		System.out.println("NAme:::" + userInfo.getName());
		userInfoRepos.save(userInfo);
	}

	@GetMapping("/getAllUserInfo")
	public List<User> getAllUserInfo() {
		return userInfoRepos.findAll();
	}

	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable int id) {
		return userInfoRepos.findById(id).get();
	}

	@PostMapping("/addAllUserInfo")
	public void addAllUserInfo(@RequestBody List<User> userInfo) {
		System.out.println("NAme:::" + userInfo.get(0).getName());
		userInfoRepos.saveAll(userInfo);
	}

	@GetMapping("/getUserCount/{user}")
	public long getUserCount(@PathVariable int user) {
		return userInfoRepos.count();
	}

	@DeleteMapping("/deleteUserById/{id}")
	public void deleteUserById(@PathVariable int id) {
		userInfoRepos.deleteById(id);
	}

	@DeleteMapping("/deleteUser/{user}")
	public void deleteUser(@PathVariable User user) {
		userInfoRepos.delete(user);
	}

	@GetMapping("/checkUserById/{id}")
	public boolean checkUserById(@PathVariable int id) {
		return userInfoRepos.existsById(id);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/checkUser/{user}/")
	public boolean checkUser(@PathVariable List<User> user) {
		return userInfoRepos.exists((Example<User>) user);
	}
	
	
	@PutMapping("/updateUser")
	public boolean updateUser(@RequestParam User user) {
		
		if(userInfoRepos.findById(user.getId()).get() != null) {
			User  userToUpdate = new User();
			userToUpdate.setName(user.getName());
			userToUpdate.setId(user.getId());
			if(userInfoRepos.save(userToUpdate) != null)
				return true;
		}
			return false;
	}
}
