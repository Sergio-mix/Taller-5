package edu.unbosque.Taller_5.jpa.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Rent") // Optional
@NamedQueries({
        @NamedQuery(name = "Rent.findAll",
                query = "SELECT b FROM Rent b")
})
public class Rent {
    @Id
    @GeneratedValue
    @Column(name = "rent_id")
    private Integer rentId;

    @Column(name = "email")
    private String email;

    @Column(name = "edition_id")
    private Integer editionId;

    @Column(name = "renting_date")
    private Date renting_date;
    public Rent() {

    }

    public Rent(Integer rentId, String email, Integer editionId, Date renting_date) {
        this.rentId = rentId;
        this.email = email;
        this.editionId = editionId;
        this.renting_date = renting_date;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEditionId() {
        return editionId;
    }

    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    public Date getRenting_date() {
        return renting_date;
    }

    public void setRenting_date(Date renting_date) {
        this.renting_date = renting_date;
    }
}
