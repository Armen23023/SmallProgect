package service;

import models.User;
import exeptions.UserAlreadyExistsException;
import exeptions.UserNotFoundException;
import storige.UserStorage;

public class UserService {

    private final UserStorage userStorage = new UserStorage();

    public User login(String email, String password) throws UserNotFoundException {
        User user = userStorage.getByEmailAndPassword(email, password);
        if (user == null)
            throw new UserNotFoundException(String.format("Models.User with email = %s and password = %s  not found", email, password));
        return user;
    }


    public User registration(User user) throws UserAlreadyExistsException {
        boolean exist = userStorage.existByEmail(user.getEmail());
        if (exist)
            throw new UserAlreadyExistsException(String.format("Models.User with email = %s already exist ", user.getEmail()));
        userStorage.add(user);
        return user;
    }
}
