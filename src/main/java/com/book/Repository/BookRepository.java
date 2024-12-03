package com.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.entity.BookEntity;

@Repository
public interface BookRepository  extends JpaRepository<BookEntity, Integer> {
    
}
