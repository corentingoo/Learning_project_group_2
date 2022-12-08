package be.ifosup.learning.controller.admin;

import be.ifosup.learning.users.in.UserIn;
import be.ifosup.learning.users.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import be.ifosup.learning.constants.RoleEnum;
import org.springframework.ui.Model;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@Controller
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
    public String createUser(@Valid @ModelAttribute("users") UserIn userIn, HttpServletRequest request) {
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
            try {
                userservice.updateResetPassword(token, email);
                String link = appUrl + "/password/resetpassword?token=" + token;
                sendRegisterEmail(email, link);
            }
            catch (Exception e) {
                System.out.print(e);
        }
        } catch (Exception e) {
            return "redirect:/admin/user/create.html";
        }
        return "redirect:/admin/user/";
    }

    @GetMapping("/delete/{id}")
    public String deleteFormation(@PathVariable("id") Long id) {
        try {
            userservice.delete(id);
        } catch (Exception e) {
            System.out.print(e);
        }
        return "redirect:/admin/user/";
    }

    @GetMapping("/update/{id}")
    public String updatepage(@PathVariable("id") String id, Model model) {
        model.addAttribute("users", userservice.get(Long.valueOf(id)));
        return "/admin/user/update";
    }
    @PostMapping("/update/{id}")
    public String updateFormation(@Valid @ModelAttribute("users") UserIn userIn, @PathVariable("id") Long id , Model model) {
        try {
            userservice.update(id, userIn);
        }
        catch(Exception e){
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
