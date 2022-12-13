package be.ifosup.learning.users.service;


import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.in.UserIdIn;
import be.ifosup.learning.users.in.UserIn;
import be.ifosup.learning.users.out.UserOut;
import be.ifosup.learning.users.repositories.UserRepository;
import be.ifosup.learning.utils.BCryptManagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
                .email(user.getEmail())
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

    public List<UserOut> listAll() {
        List<User> userRepositoryAll = userRepository.findAll();

        List<UserOut> userOuts = userRepositoryAll
                .stream()
                .map(user -> getUserOut(user))
                .collect(Collectors.toList());

        return userOuts;
    }

    public UserOut save(UserIn userIn) {

        User user = User.builder()
                .username(userIn.getUsername())
                .lastname(userIn.getLastname())
                .firstname(userIn.getFirstname())
                .email(userIn.getEmail())
                .roles(userIn.getRoles())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .enabled(true)
                .credentialsNonExpired(true)
                .build();
        User save = userRepository.save(user);
        return getUserOut(save);
    }

    public UserOut update(Long id, UserIdIn userIdIn) {
        User user = userRepository.findById(id).get();

        User toSave = User.builder()
                .id(user.getId())
                .username(userIdIn.getUsername() == null ? user.getUsername() : userIdIn.getUsername())
                .lastname(userIdIn.getLastname() == null ? user.getLastname() : userIdIn.getLastname())
                .firstname(userIdIn.getFirstname() == null ? user.getFirstname() : userIdIn.getFirstname())
                .password(user.getPassword())
                .email(userIdIn.getEmail() == null ? user.getEmail() : userIdIn.getEmail())
                .roles(userIdIn.getRoles() == null ? user.getRoles() : userIdIn.getRoles())
                .build();
        User saved = userRepository.save(toSave);
        return getUserOut(saved);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public void updateResetPassword(String token, String email){
        User user = userRepository.findByEmail(email);

        user.setToken(token);
        userRepository.save(user);

    }

    @Override
    public User findByToken(String token) {
        return userRepository.findByToken(token);
    }

    @Override
    public UserOut updatePassword(Long id, String password) {
        String passwordCrypt = BCryptManagerUtil.passwordEncoder().encode(password);
        userRepository.updatePassword(id, passwordCrypt);
        User userEntity = userRepository.getById(id);
        userRepository.updateToken(null, id);

        return getUserOut(userEntity);
    }




}
