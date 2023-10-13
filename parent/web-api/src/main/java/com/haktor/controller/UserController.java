package com.haktor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haktor.models.User;
import com.haktor.services.UserService;

import extentions.BaseController;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {
	@Autowired
	UserService userService;

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll() {
		var userlist = userService.getAll();
		if (userlist == null) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<>(userlist, HttpStatus.OK);
		}
	}

}
