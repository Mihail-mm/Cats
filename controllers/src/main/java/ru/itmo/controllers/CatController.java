package ru.itmo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmo.CatService;
import ru.itmo.OwnerService;
import ru.itmo.models.Cat;
import ru.itmo.models.Colors;

@Controller
@RequestMapping("/cats")
public class CatController {
    private CatService catService;
    private OwnerService ownerService;

    @Autowired
    public CatController(CatService catService, OwnerService ownerService) {
        this.catService = catService;
        this.ownerService = ownerService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("cats", catService.findAll());
        System.out.println(2487462);
        return "cats/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("cat", catService.findById(id));
        return "cats/show";
    }

    @GetMapping("/new")
    public String newCat(@ModelAttribute("cat") Cat cat) {
        return "cats/new";
    }

    @PostMapping()
    public String create(Cat cat) {
        catService.save(cat);
        return "redirect:/cats";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        catService.delete(id);
        return "redirect:/cats";
    }

    @GetMapping("/search")
    public String searchPage() {
        return "cats/search";
    }

    @PostMapping("/search")
    public String search(Model model, @RequestParam("query") Colors query) {
        model.addAttribute("cats", catService.findByColor(query));
        return "cats/search";
    }
}