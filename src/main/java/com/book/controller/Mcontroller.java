package com.book.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.*;
import com.book.Repository.*;
import com.book.Service.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class Mcontroller {
	
	@Autowired
	private Mrepository mrepo;
	
	@Autowired
	private Emailservice emailservice;

	
	@PostMapping("/register")
	public String register(@RequestBody Mentity user) {
		try {
			 String emailRegex = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";
			 String passwordRegex = "^(?=.[A-Za-z])(?=.\\d)(?=.*[#@])[A-Za-z\\d#@]{8,}$";
			Optional<Mentity> existinguser=mrepo.findByUseremailOrUsernumber(user.getUseremail(), user.getUsernumber());
			if(existinguser.isPresent()) {
				return "account already exists";
			}else if(user.getUseremail().matches(emailRegex) && user.getUserpassword().matches(passwordRegex)) {
				mrepo.save(user);
				return "registered successfuly";
			}
			else {
				return "Invalid email and password...";
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@GetMapping("/login/{mail}/{pass}")
	public String login(@PathVariable String mail,@PathVariable String pass) {
		try {
			Optional<Mentity> user=mrepo.findByUseremail(mail);
			if(user.isPresent()) {
				Mentity USER=user.get();
				if(USER.getUserpassword().equals(pass)) {
					return "Welcome "+USER.getUsername();
				}else {
					return "Invalid password";
				}
			}else {
				return "email not found?..";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/forgotpass/{mail}")
	public String forgotpass(@PathVariable String mail) {
		try {
			Optional<Mentity> user=mrepo.findByUseremail(mail);
			if(mrepo.existsByUseremail(mail)) {
				Mentity USER=user.get();
				String subject="Recovery of your password";
				String body="The password for your email "+mail+" is retrived, and your password "+USER.getUserpassword() +". Please continue with our appliction senior "+USER.getUsername();
				emailservice.sendMail( mail, body,subject);
				return "Your password is sent to your mail "+mail;
			}else {
				return "email not found?..";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}