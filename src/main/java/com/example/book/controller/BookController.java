package com.example.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.book.Repository.BookRepository;
import com.example.book.entity.BookEntity;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
    @Autowired
    public BookRepository bookRepository;

    // Add a new book
    @PostMapping("/addbooks")
    public BookEntity addbooks(@RequestBody BookEntity bookEntity) {
       try {
            bookRepository.save(bookEntity);
            return bookEntity;
       } catch (Exception e) {
            e.printStackTrace();
       }
       return null;
    }

    // Update an existing book
    @PutMapping("/updatebooks")
    public BookEntity updatebooks(@RequestBody BookEntity bookEntity) {
       try {
            bookRepository.save(bookEntity);
            return bookEntity;
       } catch (Exception e) {
            e.printStackTrace();
       }
       return null;
    }

    // Get all books
    @GetMapping("/getbooks")
    public List<BookEntity> getbooks() {
       try {
            return bookRepository.findAll();
       } catch (Exception e) {
            e.printStackTrace();
       }
       return null;
    }

    // Delete a book by ID
    @DeleteMapping("/deletebooks/{Id}")
    public String deletebooks(@PathVariable int Id) {
        try {
            Optional<BookEntity> mov = bookRepository.findById(Id);
            if (mov.isPresent()) {
                bookRepository.delete(mov.get());
                return "Movie deleted successfully";
            } else {
                return "Movie with ID " + Id + " not found.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while deleting movie: " + e.getMessage());
        }
    }
}
