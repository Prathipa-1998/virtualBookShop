package in.co.gradle.virtualBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.gradle.virtualBook.model.CandidateDetails;
import in.co.gradle.virtualBook.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/register")
	 public ResponseEntity<String> registerUser(@RequestBody CandidateDetails user)
	 {
		
		return userservice.registerUser(user);
		
	 }
	

}
