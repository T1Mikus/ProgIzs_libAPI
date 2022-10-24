package com.sj.libAPI.repositories;

import com.sj.libAPI.models.entities.BookReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookReservationRepository extends JpaRepository<BookReservation, UUID> {
}
