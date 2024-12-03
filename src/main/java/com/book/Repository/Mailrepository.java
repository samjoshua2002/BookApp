package com.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.entity.Mailentity;


@Repository
public interface Mailrepository extends JpaRepository<Mailentity, Long> {
}
