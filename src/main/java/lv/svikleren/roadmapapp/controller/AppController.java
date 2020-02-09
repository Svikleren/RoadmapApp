package lv.svikleren.roadmapapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.svikleren.roadmapapp.model.Person;
import lv.svikleren.roadmapapp.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import static lv.svikleren.roadmapapp.constants.Constants.REDIRECT_TO_MAIN_PAGE;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AppController {

    private final PersonService personService;

    @GetMapping("/")
    public String getAllContacts(Model model) {

        model.addAttribute("contacts", personService.getAllContacts());
        return "index";
    }

    @GetMapping("/add")
    public String showAddContactPage(Person person) {
        return "addContact";
    }

    @PostMapping("/addContact")
    public String addContact(Person person, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "addContact";
        }

        personService.addContact(person);
        return REDIRECT_TO_MAIN_PAGE;
    }

    @GetMapping("/editContact/{id}")
    public String showEditContactPage(@PathVariable Long id, Model model) {

        Person person = personService.getItemById(id);
        model.addAttribute("person", person);

        return "editContact";
    }

    @PostMapping("/updateContact/{id}")
    public String updateContact(@PathVariable("id") Long id, @Valid Person person, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            person.setId(id);
            return "editContact";
        }

        personService.updateContact(person);
        return REDIRECT_TO_MAIN_PAGE;
    }

    @GetMapping("deleteContact/{id}")
    public String deleteContact(@PathVariable("id") Long id, Model model) {

        personService.deleteContact(id);
        return REDIRECT_TO_MAIN_PAGE;
    }
}