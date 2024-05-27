package in.co.gradle.virtualBook.service;

import org.springframework.http.ResponseEntity;

import in.co.gradle.virtualBook.model.CandidateDetails;


public interface UserService {
	
	public ResponseEntity<String> registerUser(CandidateDetails user);

}
