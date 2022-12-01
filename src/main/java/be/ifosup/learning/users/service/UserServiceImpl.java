package be.ifosup.learning.users.service;

import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.out.UserOut;
import be.ifosup.learning.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("No user found with username : " + username);
        } else {
            return user;
        }
    }

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

    @Override
    public UserOut get(Long id) {
        User user = userRepository.findById(id).get();
        UserOut userOut = getUserOut(user);

        return userOut;
    }

    @Override
    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        if(username == null) {
            return null;
        }
        return userRepository.findByUsername(username);
    }

    @Override
    public UserOut findByUsername(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) return null;

        UserOut userOut = getUserOut(user);
        return userOut;
    }





}
