package Helper;

import java.io.Serializable;
import java.sql.Date;

public class FullUser implements Serializable {
    private String username;
    private String name;
    private String email;
    private String phone_number;
    private Date dob;
    private String address_1;
    private String address_2;
    private String city;
    private String state;
    private String pincode;
    private String education;
    private String employment;
    private boolean married;

    public FullUser() {
    }

    public FullUser(String username, String name, String email, String phone_number, Date dob, String address_1, String address_2, String city, String state, String pincode, String education, String employment, boolean married) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.dob = dob;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.education = education;
        this.employment = employment;
        this.married = married;
    }

    public FullUser(String username, String name, String email, String phone_number, String address_1, String address_2, String city, String state, String pincode, String education, String employment, boolean married) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.education = education;
        this.employment = employment;
        this.married = married;
    }

    public FullUser(String pincode, String education, String city, String address_1, String address_2, String name, String phone_number, String state, String employment, boolean married, String email, String username) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.education = education;
        this.employment = employment;
        this.married = married;
    }

    @Override
    public String toString() {
        return "FullUser{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", dob='" + dob + '\'' +
                ", address_1='" + address_1 + '\'' +
                ", address_2='" + address_2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode='" + pincode + '\'' +
                ", education='" + education + '\'' +
                ", employment='" + employment + '\'' +
                ", married=" + married +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
}
