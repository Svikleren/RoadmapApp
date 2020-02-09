package lv.svikleren.roadmapapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.svikleren.roadmapapp.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AppController {

    private final PersonService personService;

    @GetMapping("/")
    public String getAllContacts(Model model) {

        model.addAttribute("contacts", personService.getAllItems());
        return "index";
    }

    @GetMapping("/addContact")
    public String addContact(Model model) {

        //model.addAttribute("item", personService.getItemById(id));
        return "addContact";
    }

    @GetMapping("/editContact/{id}")
    public String editContact(@PathVariable Long id, Model model) {

        model.addAttribute("contact", personService.getItemById(id));
        return "editContact";
    }

    @GetMapping("/deleteContact/{id}")
    public String deleteContact(@PathVariable Long id, Model model) {

        //model.addAttribute("item", personService.getItemById(id));
        return "item";
    }

    @GetMapping("/test")
    public String test(Model model) {

        return "main";
    }
}
