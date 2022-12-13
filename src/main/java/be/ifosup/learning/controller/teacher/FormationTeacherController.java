package be.ifosup.learning.controller.teacher;


import be.ifosup.learning.formations.repositories.FormationRepository;
import be.ifosup.learning.formations.service.FormationService;
import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.repositories.UserRepository;
import be.ifosup.learning.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/teacher/formation")
public class FormationTeacherController {

    @Autowired
    private FormationService formationservice;
    @Autowired
    private UserService userservice;

    @Autowired
    public FormationTeacherController(FormationRepository formationRepository, UserRepository userRepository) {
        formationRepository = formationRepository;
        userRepository = userRepository;
    }

    @GetMapping()
    public String formationteacherpage(Model model) {
        User user = userservice.getCurrentUser();
        Long id = user.getId();
        model.addAttribute("formations", formationservice.listbyTeacher(id));
        return "teacher/formation/index";
    }



}
