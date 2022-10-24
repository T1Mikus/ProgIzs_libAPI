package com.sj.libAPI.models.DTO;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private int contactPhone;

    @NotNull
    private String email;

    private String password = null;

}
