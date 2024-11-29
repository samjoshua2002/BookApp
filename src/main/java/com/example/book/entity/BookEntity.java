package com.example.book.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
enum BookFormat {
    HARDCOVER,
    PAPERBACK,
    EBOOK
    
}



 enum Genre {
    FICTION, 
    MANGA,
    NON_FICTION, 
    MYSTERY, 
    FANTASY, 
    SCIENCE_FICTION,
    ROMANCE,
    THRILLER,
    BIOGRAPHY,
    HISTORY,
    CHILDREN
    
}
enum Language {
    ENGLISH,
    SPANISH,
    FRENCH,
    GERMAN,
    CHINESE,
    HINDI,
    ARABIC,
    JAPANESE,
    PORTUGUESE
}


@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId; // Auto-generated ID

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "cost_price")
    private double costPrice;

    @Column(name = "stock_quantity", nullable = false)
    private int stockQuantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    private Language language;

    @Column(name = "edition")
    private String edition;

    @Column(name = "page_count")
    private int pageCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "book_format")
    private BookFormat bookFormat;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "book_cover_image", columnDefinition = "TEXT")
    private String bookCoverImage;

    // Default constructor
    public BookEntity() {}

    // Constructor with parameters
    public BookEntity(String title, String author, String isbn, Genre genre, String publisher,
                      LocalDate publicationDate, double price, double costPrice, int stockQuantity,
                      Language language, String edition, int pageCount, BookFormat bookFormat,
                      String description, String bookCoverImage) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.price = price;
        this.costPrice = costPrice;
        this.stockQuantity = stockQuantity;
        this.language = language;
        this.edition = edition;
        this.pageCount = pageCount;
        this.bookFormat = bookFormat;
        this.description = description;
        this.bookCoverImage = bookCoverImage;
    }

    // Getters and Setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public BookFormat getBookFormat() {
        return bookFormat;
    }

    public void setBookFormat(BookFormat bookFormat) {
        this.bookFormat = bookFormat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookCoverImage() {
        return bookCoverImage;
    }

    public void setBookCoverImage(String bookCoverImage) {
        this.bookCoverImage = bookCoverImage;
    }
}
