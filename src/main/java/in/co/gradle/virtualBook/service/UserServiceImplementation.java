package in.co.gradle.virtualBook.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import in.co.gradle.virtualBook.VirtualBookshopApplication;
import in.co.gradle.virtualBook.model.Candidate;
import in.co.gradle.virtualBook.model.CandidateDetails;
import in.co.gradle.virtualBook.model.Location;
import in.co.gradle.virtualBook.repository.CandidateDetailsRepository;
import in.co.gradle.virtualBook.repository.CandidateRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	private static final Logger logger= LoggerFactory.getLogger(UserServiceImplementation.class);
	@Autowired
	private CandidateDetailsRepository userrepo;
	
	 @Autowired
	    private JavaMailSender mailSender;

	@Override
	public ResponseEntity<String> registerUser(CandidateDetails user) {
		try {
		// Generate OTP and save it as the verification code
		Candidate candidateuser=new Candidate();
		Location loc=new Location();
		BeanUtils.copyProperties(user,candidateuser);
		BeanUtils.copyProperties(user, loc);
		
        String otp = generateOTP();
        candidateuser.setVerification_Code(otp);
     // Pass email address and OTP to sendSimpleEmail method
        sendSimpleEmail(candidateuser.getMailId(), otp);
        userrepo.save(user);
        return ResponseEntity.ok("User registered successfully! Verification code sent to email.");
		}
		catch (Exception e) {
	        // If an exception occurs during registration, return an error message
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Failed to register user. Please try again later.");
	    }

    } 
	
	

	private String generateOTP() {
		// TODO Auto-generated method stub
		Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
	}

	public void sendSimpleEmail(String userEmail,String otp)
	{
		try {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("prathipathamarai98@gmail.com");
		message.setTo(userEmail);
		message.setText("your onetime passwowrd is:"+otp);
		mailSender.send(message);
		logger.info("otp hasbeen send to user mail");
	}
		catch(Exception e)
		{
			logger.error("unable to send email");
		}
	}
}
