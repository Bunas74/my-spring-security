package org.example.myspringsecurity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.myspringsecurity.dto.AuthDTO;
import org.example.myspringsecurity.service.impl.AuthServiceImpl;
import org.example.myspringsecurity.util.PersonValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl registrationService;

    private final PersonValidator personValidator;

    @GetMapping("/login")
    public String login() {
        return "/auth/login";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("authDTO") AuthDTO authDTO) {
        return "/auth/registration";
    }

    @PostMapping("/registration")
    public String createNewUser(@ModelAttribute @Valid AuthDTO authDTO, BindingResult bindingResult) {
        personValidator.validate(authDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/auth/registration";
        }
        registrationService.registration(authDTO);

        return "redirect:/auth/login";
    }
}