package com.sj.libAPI.models.DTO;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BookDTO {

    @NotNull
    private String title;

    @NotNull
    private String genre;

    @NotNull
    private int pages;

    @NotNull
    private String author;

    @NotNull
    private String publisher;

    @NotNull
    private int copies;

    @NotNull
    private String releaseDate;

    @NotNull
    private UUID libraryId;

}
