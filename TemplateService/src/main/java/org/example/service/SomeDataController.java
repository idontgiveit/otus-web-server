package org.example.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SomeDataController {
    @GetMapping(value = "people")
    public String people(Model model) {
        model.addAttribute("name", "Vasya");
        return "people";
    }

    @PostMapping(value = "people")
    public String add(Model model, String name) {
        model.addAttribute("name", name);
        return "people";
    }
}
