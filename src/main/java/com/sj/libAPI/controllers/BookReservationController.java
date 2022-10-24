package com.sj.libAPI.controllers;

import com.sj.libAPI.models.DTO.BookReservationDTO;
import com.sj.libAPI.models.entities.BookReservation;
import com.sj.libAPI.services.BookReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookReservations")
public class BookReservationController {

    @Autowired
    private BookReservationService _bookReservationService;

    @GetMapping
    public List<BookReservation> getAllBookReservations() {
        return _bookReservationService.getAllBookReservations();
    }

    @GetMapping("{id}")
    public BookReservation getBookReservationById(@PathVariable UUID id){
        return _bookReservationService.getBookReservationById(id);
    }

    @PostMapping
    public void addBookReservation(@RequestBody BookReservationDTO bookReservationDTO){
        _bookReservationService.addBookReservation(bookReservationDTO);
    }

    @PutMapping("{id}")
    public void updateBookReservation(@PathVariable UUID id, @RequestBody BookReservationDTO bookReservationDTO){
        _bookReservationService.updateBookReservation(id, bookReservationDTO);
    }

    @DeleteMapping("{id}")
    public void deleteBookReservation(@PathVariable UUID id){
        _bookReservationService.deleteBookReservation(id);
    }

}
