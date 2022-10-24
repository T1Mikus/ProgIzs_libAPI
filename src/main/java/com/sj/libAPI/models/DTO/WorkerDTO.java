package com.sj.libAPI.models.DTO;

import com.sj.libAPI.models.entities.Library;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class WorkerDTO {

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private int contactPhone;

    @NotNull
    private String email;

    private String password = null;

    @NotNull
    private UUID libraryId;

}
