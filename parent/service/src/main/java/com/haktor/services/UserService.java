package com.haktor.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haktor.models.User;
import com.haktor.repostories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User findByUserName(String username) {
		return null;
	}

	public ArrayList<User> getAll() {
		try {
			var userlist = new ArrayList<User>();
			var test = userRepository.count();
			var list = userRepository.findAll();
			list.forEach(userlist::add);
			if (userlist.isEmpty()) {
				return null;
			}
			return userlist;
		} catch (Exception e) {
			return null;
		}
	}

	public User getById(Long id) {
		Optional<User> userData = userRepository.findById(id);
		if (userData.isPresent()) {
			return userData.get();
		} else {
			return null;
		}
	}

	public User save(User user) {
		Optional<User> userData = null;
		if (user.getId() > 0) {
			userData = userRepository.findById(user.getId());
		}
		try {
			if (userData != null && userData.isPresent()) {
				User userModel = userData.get();
				userModel.setFullName(user.getFullName());
				return userRepository.save(userModel);
			} else {
				var newModel = new User(user.getUsername(), user.getFullName(), user.getEmail(), "1");
				var userModel = userRepository.save(newModel);
				return userModel;
			}
		} catch (Exception e) {
			return null;
		}
	}

	public Boolean delete(long id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
