package be.ifosup.learning.users.service;

import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.out.UserOut;
import be.ifosup.learning.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserRepository userRepository;

    public List<UserOut> listAllbyRole(String role) {
        List<User> userRepositoryAllRole = userRepository.allUserByRole(role);

        List<UserOut> userOuts = userRepositoryAllRole
                .stream()
                .map(user -> getUserOut(user))
                .collect(Collectors.toList());

        return userOuts;
    }

    private static UserOut getUserOut(User user) {
        return UserOut.builder()
                .id(user.getId())
                .username(user.getUsername())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .roles(user.getRoles())
                .build();
    }


}
