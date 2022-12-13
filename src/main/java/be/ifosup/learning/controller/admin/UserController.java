package be.ifosup.learning.controller.admin;

import be.ifosup.learning.users.in.UserIdIn;
import be.ifosup.learning.users.in.UserIn;
import be.ifosup.learning.users.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import be.ifosup.learning.constants.RoleEnum;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@Controller
@Component
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private UserService userservice;
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping()
    public String userpage(Model model) {
        model.addAttribute("users", userservice.listAll());
        return "admin/user/index";
    }

    @GetMapping("/create")
    public String usercreatepage(Model model) {
        model.addAttribute("users", new UserIn());
        return "/admin/user/create.html";
    }

    @PostMapping("/create")
    public String createUser(@Valid @ModelAttribute("users") UserIn userIn, BindingResult result, HttpServletRequest request, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "admin/user/create.html";
        } else if (userservice.usernamexist(userIn.getUsername())) {
            attributes.addFlashAttribute("messageneg", "le nom d'utilisateur existe déjà");
            return "admin/user/create.html";
        }

        UserIn.roles = new ArrayList<>();
        String role = userIn.getRole();

        if (role.equals("TEACHER")) {
            userIn.addRole(RoleEnum.TEACHER);
        } else if (role.equals("STUDENT")){
            userIn.addRole(RoleEnum.STUDENT);
        } else if (role.equals("ADMIN")) {
        userIn.addRole(RoleEnum.ADMIN);
        }

        try {
            userservice.save(userIn);
            String email = userIn.getEmail();
            String token = RandomString.make(50);
            String appUrl = ServletUriComponentsBuilder.fromRequestUri(request)
                    .replacePath(null)
                    .build()
                    .toUriString();
            attributes.addFlashAttribute("messagepos", "L'utilisateur a bien été ajouté");
            try {
                userservice.updateResetPassword(token, email);
                String link = appUrl + "/password/resetpassword?token=" + token;
                sendRegisterEmail(email, link);
                attributes.addFlashAttribute("messagepos", "Le mail d'enregistrement a bien été envoyé");
            }
            catch (Exception e) {
                attributes.addFlashAttribute("messageneg", "Impossible pour l'envoie du mail");
                System.out.print(e);
            }
        } catch (Exception e) {
            attributes.addFlashAttribute("messageneg", "Impossible de créer l'utilisateur");
            return "redirect:/admin/user/create";
        }

        return "redirect:/admin/user/";
    }

    @GetMapping("/delete/{id}")
    public String deleteFormation(@PathVariable("id") Long id, RedirectAttributes attributes) {
        try {
            userservice.delete(id);
            attributes.addFlashAttribute("messagepos", "L'utilisateur a bien été supprimé");
        } catch (Exception e) {
            attributes.addFlashAttribute("messageneg", "Impossible de supprimer l'utilisateur");
            System.out.print(e);
        }
        return "redirect:/admin/user/";
    }

    @GetMapping("/update/{id}")
    public String updatepage(@PathVariable("id") String id, Model model) {
        model.addAttribute("users", userservice.get(Long.valueOf(id)));
        return "/admin/user/update";
    }
    @PostMapping("/update")
    public String updateUser(@Valid @ModelAttribute("users") UserIdIn userIdIn, BindingResult result, RedirectAttributes attributes) {
        Long id = userIdIn.getId();
        if (result.hasErrors()) {
            attributes.addFlashAttribute("messageneg", "Tous les champs doivent être remplis");
            return "admin/user/update.html";
        }
        else if (userservice.usernamexist(userIdIn.getUsername())) {
            attributes.addFlashAttribute("messageneg", "le nom d'utilisateur existe déjà");
            return "redirect:/admin/user/update/" + id;
        }


        try {
            userservice.update(id, userIdIn);
            attributes.addFlashAttribute("messagepos", "L'utilisateur a bien été modifié");
        }
        catch(Exception e){
            System.out.print(e);
            attributes.addFlashAttribute("messageneg", "Impossible de modifier l'utilisateur");
        }

        return "redirect:/admin/user/";
    }

    private void sendRegisterEmail(String email, String resetPasswordLink) throws MessagingException, UnsupportedEncodingException, MailSendException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("learningifosup@hotmail.com", "Lia support");
        helper.setTo(email);
        String subject = "Enregistrement pour Learning Project";
        String content = "<p>Bonjour,</p>"
                + "<p>Un compte a été créé dans la plateforme Learning Project</p>"
                + "<p>Cliquez sur le lien ci-dessous pour créer votre mot de passe: </p>"
                + "<p><b><a href=\"" + resetPasswordLink + "\" > Changer mon mot de passe</a></b></p>";
        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
    }


    

}
