package com.jackdaw.bookings.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GuestDto {
    private int id;
    private String firstName;
    private String surname;
    private String cellphoneNumber;
    private String email;

    @JsonCreator
    public GuestDto(@JsonProperty("id") final int id, @JsonProperty("firstName") final String firstName,
                    @JsonProperty("surname") final String surname,
                    @JsonProperty("cellphoneNumber") final String cellphoneNumber,
                    @JsonProperty("email") final String email) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.cellphoneNumber = cellphoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
