package be.ifosup.learning.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Student controller
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping
    public String studentPage() {
        return "student/index";
    }
}
