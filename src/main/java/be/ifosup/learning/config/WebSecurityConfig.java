package be.ifosup.learning.config;

import be.ifosup.learning.constants.RoleEnum;
import be.ifosup.learning.utils.BCryptManagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * Gestion de la sécurité de l'application
 */

/**
 * V2 update pour ajout teacher et student et retrait user pour clarification
 */


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Définition des rôles sous forme de constantes
     */
    private final String ADMIN_ROLE = RoleEnum.ADMIN.name();
    private final String TEACHER_ROLE = RoleEnum.TEACHER.name();
    private final String STUDENT_ROLE = RoleEnum.STUDENT.name();

    /**
     * On déclare les services / utilitaires que l'on va utiliser
     */
    private final UserDetailsService userDetailsService;
    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    /**
     * Définition du constructeur avec l'instance des services utilisés
     * @param userDetailsService
     * @param authenticationSuccessHandler
     */
    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService,
                             AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.userDetailsService = userDetailsService;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    /**
     * Configuration de la gestion de l'authentification en base
     * @param authenticationManagerBuilder
     * @throws Exception
     */
    @Autowired
    public void configAuthentification(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(BCryptManagerUtil.passwordEncoder());
    }

    /**
     * Règle pour l'authentification
     * On déclare que pour /admin ,/teacher et /student, il faut être authentifié
     * On définit les rôles par pattern d'url
     * On définit que le /* est authorisé à tous
     * On définit la page de login et le succesHandler, qui utilise indirectement le CustomAuthentificationSuccesHandler pour rediriger sur le bon pattern en fonction du rôle
     * On définit les paramètres pour username et password
     * Définition du logout
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**", "/teacher/**", "/student/**").authenticated()
                .antMatchers("/admin/**").hasAuthority(ADMIN_ROLE)
                .antMatchers("/teacher/**").hasAuthority(TEACHER_ROLE)
                .antMatchers("/student/**").hasAuthority(STUDENT_ROLE)
                .antMatchers("/*").permitAll()
            .and()
                .formLogin().loginPage("/login").successHandler(authenticationSuccessHandler).failureUrl("/login")
                .usernameParameter("username").passwordParameter("password")
            .and()
                .logout().invalidateHttpSession(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
            .and()
                .csrf().disable();

    }
}
