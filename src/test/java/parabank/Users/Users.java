package parabank.Users;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Users.UsersBuilder.class)
public class Users {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zipCode;
    String phone;
    String ssn;
    String username;
    String password;
    String confirmPassword;



//    @JsonIgnoreProperties(ignoreUnknown = true)
//    @JsonPOJOBuilder(withPrefix = "")
//    public static final class UserBuilder {
//
//    }

    public Users (String firstName, String lastName, String address, String city, String state, String zipCode, String phone, String ssn, String username, String password, String confirmPassword) {
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
        this.confirmPassword = password;

    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
        return address;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZipCode() {
        return zipCode;
    }
    public String getPhone() {
        return phone;
    }
    public String getSsn() {
        return ssn;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getConfirmPassword() {
        return password;
    }
}
