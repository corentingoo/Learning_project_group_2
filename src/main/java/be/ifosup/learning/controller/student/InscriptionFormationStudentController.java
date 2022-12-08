package be.ifosup.learning.controller.student;


import be.ifosup.learning.formations.repositories.FormationRepository;
import be.ifosup.learning.formations.service.FormationService;
import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.repositories.UserRepository;
import be.ifosup.learning.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/student/inscription/formation")
public class InscriptionFormationStudentController {

    @Autowired
    private FormationService formationService;
    @Autowired
    private UserService userservice;

    @Autowired
    public InscriptionFormationStudentController(FormationRepository formationRepository, UserRepository userRepository) {
        formationRepository = formationRepository;
        userRepository = userRepository;
    }

    // Methods for Retrieval operations
    @GetMapping()
    public String inscriptionformationstudentpage(Model model) {
        User user = userservice.getCurrentUser();
        Long id = user.getId();

        model.addAttribute("formations", formationService.listAll());
        model.addAttribute("user", userservice.getCurrentUser().getId());
        return "student/inscription/formation";
    }



}
