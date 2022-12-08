package be.ifosup.learning.config;

import be.ifosup.learning.constants.RoleEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Permet de rediriger l'utilisateur sur un controller ou l'autre en fonction de son rôle
 */

@Configuration
public class CustomAuthentificationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if(roles.contains(RoleEnum.ADMIN.name())) {
            httpServletResponse.sendRedirect("/admin");
        } else if(roles.contains(RoleEnum.TEACHER.name())) {
            httpServletResponse.sendRedirect("/teacher");
        } else {
            httpServletResponse.sendRedirect("/student");
        }
    }
}
