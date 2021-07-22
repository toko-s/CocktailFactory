package service;

import dao.UserDao;
import model.User;
import response.UserResponse;

public class UserService {

    public static UserResponse register(User user){
        UserDao userDao = UserDao.getInstance();
        if (userDao.getByUsername(user.getUsername()) != null){
            return new UserResponse(user, UserResponse.ResponseType.USER_ALREADY_REGISTERED);
        }
        return new UserResponse(userDao.add(user), UserResponse.ResponseType.SUCCESS);
    }

    public static UserResponse login(User user){
        UserDao userDao = UserDao.getInstance();
        User u = userDao.getByUsername(user.getUsername());
        if (u == null)
            return new UserResponse(user, UserResponse.ResponseType.INCORRECT_USERNAME);
        if (!u.getPassword().equals(user.getPassword()))
            return new UserResponse(user, UserResponse.ResponseType.INCORRECT_PASSWORD);
        return new UserResponse(u, UserResponse.ResponseType.SUCCESS);
    }
}
