package com.sj.libAPI.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sj.libAPI.models.DTO.UserDTO;
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
@Table(name = "`User`")
public class User extends BaseEntity {

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    @JsonManagedReference(value = "user-book_reservation-movement")
    @OneToMany(mappedBy = "user")
    private Set<BookReservation> bookReservations;

    public User(UUID id){
        this.id = id;
    }

    public User(UserDTO dto){
        this.name = dto.getName();
        this.surname = dto.getSurname();
        this.contactPhone = dto.getContactPhone();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
    }

}
