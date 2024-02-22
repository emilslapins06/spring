package rvt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
//import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DefaultController {

    @GetMapping(value = "/")
    ModelAndView index() {
        ArrayList<Student> students = new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("students", students);
        modelAndView.addObject("date", new Date().toString());
        return modelAndView;
    }

    @GetMapping(value = "/test")
    public ModelAndView testAction() {
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("output1", 1);
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public ModelAndView showRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView("registration-page");
        List<String> groups = new ArrayList<>(List.of("DP2-1", "DP2-2", "DP2-3", "DP2-4"));

        Student student = new Student();
        modelAndView.addObject("groups", groups);
        modelAndView.addObject("student", student);

        return modelAndView;
    }

    @GetMapping(value = "/registration-success")
    public ModelAndView registerSuccess() {
        ModelAndView modelAndView = new ModelAndView("registration-success");
        modelAndView.addObject("output1", 1);
        return modelAndView;
    }

    @PostMapping(value = "/register")
    public String registration(@ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration-page";
        }
        return "redirect:/registration-success";
    }

}