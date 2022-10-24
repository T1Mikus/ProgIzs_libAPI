package com.sj.libAPI.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sj.libAPI.models.DTO.LibraryDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "`Library`")
public class Library {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "contact_phone", nullable = false)
    private int contactPhone;

    @JsonManagedReference(value = "library-book-movement")
    @OneToMany(mappedBy = "library")
    private Set<Book> books;

    @JsonManagedReference(value = "library-worker-movement")
    @OneToMany(mappedBy = "library")
    private Set<Worker> workers;

    public Library(UUID id) {
        this.id = id;
    }
    public Library(LibraryDTO dto) {
        this.name = dto.getName();
        this.address = dto.getAddress();
        this.contactPhone = dto.getContactPhone();
    }

}
