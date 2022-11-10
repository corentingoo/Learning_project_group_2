package be.ifosup.learning.webservice.controller.ResetPassord;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/passwordAskReset")
public class ResetPasswordController {
    @GetMapping
    public String ResetFrom() {
        return "/passwordAskReset/index";
    }
}
