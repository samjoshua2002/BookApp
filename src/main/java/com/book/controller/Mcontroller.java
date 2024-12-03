package com.book.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.Repository.Mrepository;
import com.book.Service.Emailservice;
import com.book.entity.Mentity;

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
			Optional<Mentity> existinguser=mrepo.findByUseremailOrUsernumber(user.getUseremail(), user.getUsernumber());
			if(existinguser.isPresent()) {
				return "account already exists";
			}
			 mrepo.save(user);
			return "registered successfuly";
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
