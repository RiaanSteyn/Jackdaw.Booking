package com.jackdaw.bookings.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private int firstName;

    @Column(name = "surname")
    private int surname;

    @Column(name = "cellphone_number")
    private int cellphoneNumber;

    @Column(name = "email")
    private int email;

    public Guest(int id, int firstName, int surname, int cellphoneNumber, int email) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.cellphoneNumber = cellphoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int getFirstName() {
        return firstName;
    }

    public int getSurname() {
        return surname;
    }

    public int getCellphoneNumber() {
        return cellphoneNumber;
    }

    public int getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Guest guest = (Guest) o;

        return new EqualsBuilder()
                .append(id, guest.id)
                .append(firstName, guest.firstName)
                .append(surname, guest.surname)
                .append(cellphoneNumber, guest.cellphoneNumber)
                .append(email, guest.email)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(firstName)
                .append(surname)
                .append(cellphoneNumber)
                .append(email)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("firstName", firstName)
                .append("surname", surname)
                .append("cellphoneNumber", cellphoneNumber)
                .append("email", email)
                .toString();
    }
}
