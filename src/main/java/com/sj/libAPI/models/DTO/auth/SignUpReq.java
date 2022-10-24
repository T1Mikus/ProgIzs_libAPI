package com.sj.libAPI.models.DTO.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SignUpReq {

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private int contactPhone;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private boolean isWorker;

    @NotNull
    private UUID library;

    @JsonProperty("isWorker")
    public boolean getIsWorker() {
        return isWorker;
    }

    public void setIsWorker(boolean worker) {
        isWorker = worker;
    }

}
