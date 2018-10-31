package com.jackdaw.bookings.model;

import com.jackdaw.bookings.dto.GuestDto;
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
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "cellphone_number")
    private String cellphoneNumber;

    @Column(name = "email")
    private String email;

    public Guest() {
    }

    public Guest(int id, String firstName, String surname, String cellphoneNumber, String email) {
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

    public GuestDto toDto() {
        return new GuestDto(id, firstName, surname, cellphoneNumber, email);
    }
}
