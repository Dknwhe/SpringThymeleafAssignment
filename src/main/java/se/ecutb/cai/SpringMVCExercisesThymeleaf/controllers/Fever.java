package se.ecutb.cai.SpringMVCExercisesThymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Fever {



    @GetMapping("/temper")
    public String fever() {
        return "temper";
    }

    @PostMapping("temper")
    public String temperature(@RequestParam(value = "temperature") double temper, Model model) {
        String message = "";
        //wiki
        if (temper >= 36.5 && temper <= 37.5) {
            message = "normal";
        }else if (temper > 37.5 && temper <= 38) {
            message = "fever";
        }else if (temper > 38) {
            message = "high-fever";
        }

        model.addAttribute("temperature", message);
        return "redirect: temper";
    }
}
