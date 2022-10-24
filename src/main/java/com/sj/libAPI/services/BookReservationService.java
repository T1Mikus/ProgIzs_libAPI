package com.sj.libAPI.services;

import com.sj.libAPI.models.DTO.BookReservationDTO;
import com.sj.libAPI.models.entities.BookReservation;
import com.sj.libAPI.models.entities.Worker;
import com.sj.libAPI.repositories.BookReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookReservationService {

    @Autowired
    private BookReservationRepository _bookReservationRepository;

    public List<BookReservation> getAllBookReservations() {
        return new ArrayList<>(_bookReservationRepository.findAll());
    }

    public BookReservation getBookReservationById(UUID id) {
        return _bookReservationRepository.findById(id).orElse(null);
    }

    public void addBookReservation(BookReservationDTO bookReservationDTO){
        BookReservation newBookReservation = new BookReservation(bookReservationDTO);
        newBookReservation.setBorrowDate(LocalDate.now());
        newBookReservation.setReturnDate(newBookReservation.getBorrowDate().plus(1, ChronoUnit.WEEKS));
        newBookReservation.setIsReturned(false);
        _bookReservationRepository.save(newBookReservation);
    }

    public void updateBookReservation(UUID id, BookReservationDTO bookReservationDTO){
        BookReservation updatedBookReservation = new BookReservation(bookReservationDTO);
        updatedBookReservation.setId(id);
        _bookReservationRepository.save(updatedBookReservation);
    }

    public void deleteBookReservation(UUID id){
        _bookReservationRepository.deleteById(id);
    }

}
