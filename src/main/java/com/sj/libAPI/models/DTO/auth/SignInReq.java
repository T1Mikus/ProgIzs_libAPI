package com.sj.libAPI.models.DTO.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInReq {

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private boolean isWorker;

    @JsonProperty("isWorker")
    public boolean getIsWorker() {
        return isWorker;
    }

    public void setIsWorker(boolean worker) {
        isWorker = worker;
    }

}
