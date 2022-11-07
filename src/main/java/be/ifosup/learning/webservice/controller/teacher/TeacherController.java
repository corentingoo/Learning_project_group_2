package be.ifosup.learning.webservice.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Admin controller
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @GetMapping
    public String teacherPage() {
        return "teacher/index";
    }
}