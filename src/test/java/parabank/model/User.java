package parabank.model;

import org.openqa.selenium.By;

public class User {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String ssn;
    private String username;
    private String password;

    public User(String firstName, String lastName, String address, String city, String state, String zipCode, String phone, String ssn, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
        this.ssn = ssn;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }
    public String getPhone() { return phone; }
    public String getSsn() { return ssn; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
