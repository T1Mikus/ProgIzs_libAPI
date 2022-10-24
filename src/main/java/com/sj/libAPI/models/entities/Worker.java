package com.sj.libAPI.models.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sj.libAPI.models.DTO.WorkerDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "`Worker`")
public class Worker extends BaseEntity {

    @JsonBackReference(value = "library-worker-movement")
    @ManyToOne
    @JoinColumn(name = "lib_id", nullable = false)
    private Library library;

    @JsonManagedReference(value = "worker-book_reservation-movement")
    @OneToMany(mappedBy = "worker")
    private Set<BookReservation> bookReservations;

    public Worker(UUID id){
        this.id = id;
    }

    public Worker(WorkerDTO dto){
        this.name = dto.getName();
        this.surname = dto.getSurname();
        this.contactPhone = dto.getContactPhone();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.library = new Library(dto.getLibrary());
    }

}
