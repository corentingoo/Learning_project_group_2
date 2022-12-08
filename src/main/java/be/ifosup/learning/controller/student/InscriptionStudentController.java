package be.ifosup.learning.controller.student;


import be.ifosup.learning.formations.repositories.FormationRepository;
import be.ifosup.learning.formations.service.FormationService;
import be.ifosup.learning.inscriptions.repositories.InscriptionRepository;
import be.ifosup.learning.inscriptions.service.InscriptionService;
import be.ifosup.learning.users.entities.User;
import be.ifosup.learning.users.repositories.UserRepository;
import be.ifosup.learning.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/student/inscription")
public class InscriptionStudentController {

    @Autowired
    private InscriptionService inscriptionservice;
    @Autowired
    private UserService userservice;

    @Autowired
    public InscriptionStudentController(InscriptionRepository inscriptionRepository, UserRepository userRepository) {
        inscriptionRepository = inscriptionRepository;
        userRepository = userRepository;
    }

    // Methods for Retrieval operations
    @GetMapping()
    public String inscriptionstudentpage(Model model) {
        User user = userservice.getCurrentUser();
        Long id = user.getId();

        model.addAttribute("inscriptions", inscriptionservice.findAllByStudentId(id));
        return "student/inscription/index";
    }



}
