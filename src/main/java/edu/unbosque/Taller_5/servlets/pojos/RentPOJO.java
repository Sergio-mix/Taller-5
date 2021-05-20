package edu.unbosque.Taller_5.servlets.pojos;

import java.util.Date;

public class RentPOJO {
    private Integer rentID;
    private String email;
    private Integer editionId;
    private String rentingDate ;

    public RentPOJO(Integer rentID, String email, Integer editionId, String rentingDate) {
        this.rentID = rentID;
        this.email = email;
        this.editionId = editionId;
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

    public Integer getEditionId() {
        return editionId;
    }

    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    public String getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(String rentingDate) {
        this.rentingDate = rentingDate;
    }
}
