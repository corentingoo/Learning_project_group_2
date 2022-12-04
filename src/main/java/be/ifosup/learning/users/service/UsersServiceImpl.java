package be.ifosup.learning.users.service;

import be.ifosup.learning.constants.RoleEnum;
import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.in.UserIn;
import be.ifosup.learning.users.out.UserOut;
import be.ifosup.learning.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UserRepository userRepository;


    /**
     * read all
     */
    public List<UserOut> listAll() {
        List<User> userRepositoryALL = userRepository.findAll();


        /** L'avantage avec la méthode stream() est
         *  que l'on peut rajouter une methode filter() par la suite
         *  */
        List<UserOut> userOuts = userRepositoryALL
                .stream()
                .map(user -> getUserOut(user))
                .collect(Collectors.toList());

        return userOuts;
    }



    /** method getUserOut() */
    private static UserOut getUserOut(User user) {
        return UserOut.builder()
                .id_user(user.getId())
                .account_non_expired(user.isAccountNonExpired())
                .account_non_locked(user.isAccountNonLocked())
                .credentials_non_expired(user.isCredentialsNonExpired())
                .enabled(user.isEnabled())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .username(user.getUsername())
                .roles(user.getRoles())
                .email(user.getEmail())
                .build();
    }


    /** method create */
    @Override
    public UserOut save(UserIn creationIn) {
        /** recherche de notre constructeur */

        Collection roles = new ArrayList();
        roles.add(RoleEnum.STUDENT);

        User user = User.builder()
                .username(creationIn.getUsername())
                .lastname(creationIn.getLastname())
                .firstname(creationIn.getFirstname())
                .roles(roles)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .email(creationIn.getEmail())
                .password("STUDENT")
//                .BCryptManagerUtil.password(password("STUDENT"))
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



    /**
     * read 1
     */
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
