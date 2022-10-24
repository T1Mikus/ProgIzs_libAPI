package com.sj.libAPI.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sj.libAPI.models.DTO.BookDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.UUID;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "`Book`")
public class Book {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "pages", nullable = false)
    private int pages;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "copies", nullable = false)
    private int copies;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @JsonBackReference(value = "library-book-movement")
    @ManyToOne
    @JoinColumn(name = "lib_id", nullable = false)
    private Library library;

    @JsonManagedReference(value = "book-book_reservation-movement")
    @OneToMany(mappedBy = "book")
    private Set<BookReservation> bookReservations;

    public Book(UUID id){
        this.id = id;
    }

    public Book(BookDTO dto){
        this.title = dto.getTitle();
        this.genre = dto.getGenre();
        this.pages = dto.getPages();
        this.author = dto.getAuthor();
        this.publisher = dto.getPublisher();
        this.copies = dto.getCopies();
        this.releaseDate = LocalDate.parse(dto.getReleaseDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.library = new Library(dto.getLibrary());
    }

}
