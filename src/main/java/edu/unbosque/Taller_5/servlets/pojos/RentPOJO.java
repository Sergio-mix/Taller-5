package edu.unbosque.Taller_5.servlets.pojos;

import java.util.Date;

public class RentPOJO {
    private Integer rentID;
    private String email;
    private String edition;
    private Date rentingDate ;

    public RentPOJO(Integer rentID, String email, String edition, Date rentingDate) {
        this.rentID = rentID;
        this.email = email;
        this.edition = edition;
        this.rentingDate = rentingDate;
    }

    public Integer getRentID() {
        return rentID;
    }

    public void setRentID(Integer rentID) {
        this.rentID = rentID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Date getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(Date rentingDate) {
        this.rentingDate = rentingDate;
    }
}
