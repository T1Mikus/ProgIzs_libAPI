package com.sj.libAPI.models.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BookReservationDTO {

    @NotNull
    private String borrowDate;

    @NotNull
    private String returnDate;

    @NotNull
    private boolean isReturned;

    @NotNull
    private UUID bookId;

    @NotNull
    private UUID userId;

    private UUID workerId = null;

    @JsonProperty("isReturned")
    public boolean getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(boolean returned) {
        isReturned = returned;
    }

}
