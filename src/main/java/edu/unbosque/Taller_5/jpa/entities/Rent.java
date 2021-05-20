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

    @Column(name = "email_recibido")
    private String email;

    @ManyToOne
    @JoinColumn(name = "email")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "edition_id")
    private Edition edition;

    @Column(name = "renting_date")
    private String renting_date;


    public Rent(String email, String rentingDate) {
    this.email=email;
    this.renting_date=rentingDate;
    }

    public Rent() {

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public String getRenting_date() {
        return renting_date;
    }

    public void setRenting_date(String renting_date) {
        this.renting_date = renting_date;
    }


}
