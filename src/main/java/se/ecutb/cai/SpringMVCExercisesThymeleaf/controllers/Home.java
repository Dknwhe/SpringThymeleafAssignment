package se.ecutb.cai.SpringMVCExercisesThymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {

    private List<String> stringList = new ArrayList<>();

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam String name) {
        if(!name.isEmpty()) {
            stringList.add(name);
        }
        return "redirect:/contact";
    }

    @GetMapping("/list-view")
    public String contactList(Model model) {
        model.addAttribute("names", stringList);
        return "view";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("image", "/img/test.jpg" );
        return "about";
    }

}
