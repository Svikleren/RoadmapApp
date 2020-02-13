package lv.svikleren.roadmapapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.svikleren.roadmapapp.dto.ContactDto;
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

        model.addAttribute("persons", personService.getAllContacts());
        return "index";
    }

    @GetMapping("/add")
    public String showAddContactPage(ContactDto contactDto) {
        return "addContact";
    }

    @PostMapping("/addContact")
    public String addContact(@Valid ContactDto contactDto, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "addContact";
        }

        personService.addContact(contactDto);
        return REDIRECT_TO_MAIN_PAGE;
    }

    @GetMapping("/editContact/{id}")
    public String showEditContactPage(@PathVariable Long id, Model model) {

        model.addAttribute("person", personService.getItemById(id));

        return "editContact";
    }

    @PostMapping("/updateContact/{id}")
    public String updateContact(@PathVariable("id") Long id, @Valid ContactDto contactDto, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            contactDto.setId(id);
            return "editContact";
        }

        personService.updateContact(contactDto);
        return REDIRECT_TO_MAIN_PAGE;
    }

    @GetMapping("deleteContact/{id}")
    public String deleteContact(@PathVariable("id") Long id, Model model) {

        personService.deleteContact(id);
        return REDIRECT_TO_MAIN_PAGE;
    }
}