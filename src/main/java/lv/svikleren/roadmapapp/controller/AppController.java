package lv.svikleren.roadmapapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.svikleren.roadmapapp.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AppController {

    private final ItemService itemService;

    @GetMapping("/")
    public String getAllProductsInTable(Model model) {

        model.addAttribute("items", itemService.getAllItems());
        return "index";
    }
}
