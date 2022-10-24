package com.sj.libAPI.models.DTO;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibraryDTO {

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private int contactPhone;

}
