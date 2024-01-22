package org.example.myspringsecurity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.myspringsecurity.dto.EditDTO;
import org.example.myspringsecurity.service.impl.AdminServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
@Secured("ROLE_ADMIN")
public class AdminController {

    private final AdminServiceImpl adminService;

    private final ModelMapper modelMapper;

    @GetMapping("/info/{id}")
    public String adminPage(@PathVariable("id") Long id, Model model) {
        adminService.findById(id)
                .ifPresent(person -> model.addAttribute("person", person));

        return "admin/info";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") Long id, Model model) {
        adminService.findById(id)
                .ifPresent(person -> model.addAttribute("editDTO", modelMapper.map(person, EditDTO.class)));

        return "admin/edit";
    }

    @PostMapping("/edit")
    public String updatePerson(@ModelAttribute @Valid EditDTO editDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/edit";
        }
        adminService.updatePerson(editDTO);

        return "redirect:/people";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        adminService.deletePerson(id);

        return "redirect:/people";
    }
}