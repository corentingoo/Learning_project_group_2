package be.ifosup.learning.users.service;

import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.out.UserOut;

import java.util.List;

public interface UserService {
    List<UserOut> listAllbyRole(String role);

    UserOut get(Long id);

    User getCurrentUser();

    UserOut findByUsername(String username);


}
