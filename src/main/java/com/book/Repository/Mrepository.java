package com.book.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Mentity;



public interface Mrepository extends JpaRepository< Mentity, Integer> {
	boolean existsByUseremail(String useremail);
	boolean existsByUsername(String username);
	boolean existsByUsernumber(long usernumber);
//	with the help of jpa
	Optional<Mentity> findByUseremail(String useremail);
	Optional<Mentity> findByUseremailOrUsernumber(String useremail,long usernumber);
	Optional<Mentity> findByUseremailOrUserpassword(String useremail,String userpassword);
}
