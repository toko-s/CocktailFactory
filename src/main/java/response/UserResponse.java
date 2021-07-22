package response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.User;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {

    private User user;

    private ResponseType type;

    public enum ResponseType{
        SUCCESS,
        USER_ALREADY_REGISTERED,
        INCORRECT_PASSWORD,
        INCORRECT_USERNAME
    }
}
