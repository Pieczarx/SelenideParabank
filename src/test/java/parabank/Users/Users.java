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
    String username;
    String password;



//    @JsonIgnoreProperties(ignoreUnknown = true)
//    @JsonPOJOBuilder(withPrefix = "")
//    public static final class UserBuilder {
//
//    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
