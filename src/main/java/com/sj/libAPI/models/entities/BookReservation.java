package com.sj.libAPI.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sj.libAPI.models.DTO.BookReservationDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "`BookReservation`")
public class BookReservation {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "borrow_date", nullable = false)
    private LocalDate borrowDate;

    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

    @Column(name = "is_returned", nullable = false)
    private boolean isReturned;

    @JsonBackReference(value = "book-book_reservation-movement")
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @JsonBackReference(value = "user-book_reservation-movement")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonBackReference(value = "worker-book_reservation-movement")
    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    public BookReservation(BookReservationDTO dto) {
        this.borrowDate = LocalDate.parse(dto.getBorrowDate());
        this.returnDate = LocalDate.parse(dto.getReturnDate());
        this.isReturned = dto.getIsReturned();
        this.book = new Book(dto.getBookId());
        this.user = new User(dto.getUserId());
        this.worker = dto.getWorkerId() != null ? new Worker(dto.getWorkerId()) : null;
    }

    @JsonProperty("isReturned")
    public boolean getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(boolean returned) {
        isReturned = returned;
    }
}
