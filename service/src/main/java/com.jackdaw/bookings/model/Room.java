package com.jackdaw.bookings.model;

import com.jackdaw.bookings.dto.RoomDto;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "beds")
    private int beds;

    public Room() {
    }

    public Room(int id, String description, double price, int beds) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return new EqualsBuilder()
                .append(id, room.id)
                .append(price, room.price)
                .append(beds, room.beds)
                .append(description, room.description)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(description)
                .append(price)
                .append(beds)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("description", description)
                .append("price", price)
                .append("beds", beds)
                .toString();
    }

    public RoomDto toDto() {
        return new RoomDto(id, description, price, beds);
    }
}
