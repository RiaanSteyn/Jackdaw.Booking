package com.jackdaw.bookings.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDto {
    private int id;
    private String description;
    private double price;
    private int beds;

    @JsonCreator
    public RoomDto(@JsonProperty("id") final int id, @JsonProperty("description") final String description,
                   @JsonProperty("price") final double price, @JsonProperty("beds") final int beds) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.beds = beds;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getBeds() {
        return beds;
    }
}
