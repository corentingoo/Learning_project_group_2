package be.ifosup.learning.users.service;

import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.in.UserIdIn;
import be.ifosup.learning.users.in.UserIn;
import be.ifosup.learning.users.out.UserOut;

import java.util.List;

public interface UserService {
    List<UserOut> listAllbyRole(String role);

    UserOut get(Long id);

    User getCurrentUser();

    UserOut findByUsername(String username);

    List<UserOut> listAll();

    UserOut save(UserIn userIn);

    UserOut update(Long id, UserIdIn userIdIn);

    void delete(Long id);

    public void updateResetPassword(String token, String email);

    User findByToken(String token);

    UserOut updatePassword(Long id,String password);
}
