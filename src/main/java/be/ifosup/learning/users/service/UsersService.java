package be.ifosup.learning.users.service;

import be.ifosup.learning.users.out.UserOut;

import java.util.List;

public interface UsersService {
    List<UserOut> listAllbyRole(String role);


}
