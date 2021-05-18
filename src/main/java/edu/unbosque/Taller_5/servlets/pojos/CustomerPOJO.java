package edu.unbosque.Taller_5.servlets.pojos;

/**
 * Class CustomerPojo
 */
public class CustomerPOJO {

    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;

    public CustomerPOJO() {
    }

    /**
     * Constructor
     * @param email
     * @param firstName
     * @param lastName
     * @param gender
     * @param age
     */
    public CustomerPOJO(String email, String firstName, String lastName, String gender, Integer age) {

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
