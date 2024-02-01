package rvt;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class DefaultController {

    /*@GetMapping(value = "/")
    ModelAndView index() {
        ArrayList<Student> students = new CsvManager(CsvManager.STUDENT_CSV).getAllStudents();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("students", students);
        modelAndView.addObject("date", new Date().toString());
        return modelAndView;
    }
    */

    @GetMapping(value = "/about")
    ModelAndView about(@RequestParam HashMap<String, String> queryStringParams) {
            ModelAndView modelAndView = new ModelAndView("about");

            String id = queryStringParams.get("id");
            String title = queryStringParams.get("title");
            String description = queryStringParams.get("description");

            return modelAndView;
    }

    @GetMapping(value = "/test")
    public ModelAndView testAction() {
        ModelAndView modelAndView = new ModelAndView("test");

        
        modelAndView.addObject("output1", 1);
     

        return modelAndView;
    }

    @RequestMapping(value = "/register")
    public ModelAndView registerPage()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;

    }

}