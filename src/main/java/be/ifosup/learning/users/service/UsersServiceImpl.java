package be.ifosup.learning.users.service;

import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.in.UserIn;
import be.ifosup.learning.users.out.UserOut;
import be.ifosup.learning.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UserRepository userRepository;

    @Override
    /** read all */
    public List<UserOut> listAll() {
        List<User> userRepositoryALL = userRepository.findAll();


        /** L'avantage avec la méthode stream() est
         *  que l'on peut rajouter une methode filter() par la suite
         *  */
        List<UserOut> userOuts = userRepositoryALL
                .stream()
                .map(user -> getUserOut(user))
                .collect(Collectors.toList());

        return  userOuts;
    }



    /** method getUserOut() */
    private static UserOut getUserOut(User user) {
        return UserOut.builder()
                .id(user.getId())
                .username(user.getUsername())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .roles(user.getRoles())
                .accountNonExpired(user.isAccountNonExpired())
                .accountNonLocked(user.isAccountNonLocked())
                .credentialsNonExpired(user.isCredentialsNonExpired())
                .enabled(user.isEnabled())
                .email(user.getEmail())
                .build();
    }


    /** method create */
    @Override
    public UserOut save(UserIn creationIn) {
        /** recherche de notre constructeur */
        User user = User.builder()
                .username(creationIn.getUsername())
                .lastname(creationIn.getLastname())
                .firstname(creationIn.getFirstname())
                .roles(creationIn.getRoles())
                .accountNonExpired(creationIn.isAccountNonExpired())
                .accountNonLocked(creationIn.isAccountNonLocked())
                .credentialsNonExpired(creationIn.isCredentialsNonExpired())
                .enabled(creationIn.isEnabled())
                .email(creationIn.getEmail())
                .build();

        /** enregistrement dans la base de données */
        User save = userRepository.save(user);
        return getUserOut(save);
    }


    /** method update */
    @Override
    public UserOut update(Long id, UserIn creationIn) {
        /** recherche de l'élément à modifier sur base de son id */
        User user = userRepository.findById(id).get();

        /** construction de notre user modifié */
        User toSave = User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .roles(user.getRoles())
                .accountNonExpired(user.isAccountNonExpired())
                .accountNonLocked(user.isAccountNonLocked())
                .credentialsNonExpired(user.isCredentialsNonExpired())
                .enabled(user.isEnabled())
                .email(user.getEmail())
                .build();

        /** enregistrement dans la base de données */
        User saved = userRepository.save(toSave);
        return getUserOut(saved);

    }



    /** read 1 */
    @Override
    public UserOut get(Long id) {
        /** récupération de notre info depuis la base de données */
        User user = userRepository.findById(id).get();

        /** cet info récupérée est envoyé vers mon DTO out, càd vers le front */
        UserOut userOut = getUserOut(user);
        return userOut;
    }



    /** method delete */
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
