package ru.itmo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmo.OwnerService;
import ru.itmo.models.Owner;

@Controller
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("owner", ownerService.findById(id));
        model.addAttribute("cats", ownerService.getCatsByOwnerId(id));

        return "owners/show";
    }

    @GetMapping("/new")
    public String newOwner(@ModelAttribute("owner") Owner owner) {
        return "owners/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("owner") Owner owner) {
        ownerService.save(owner);
        return "redirect:/owners";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        ownerService.delete(id);
        return "redirect:/owners";
    }
}

