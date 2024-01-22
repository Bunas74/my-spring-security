package org.example.myspringsecurity.service.impl;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.example.myspringsecurity.dto.AuthDTO;
import org.example.myspringsecurity.model.Person;
import org.example.myspringsecurity.repository.PeopleRepository;
import org.example.myspringsecurity.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PeopleRepository peopleRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    @Transactional
    public void registration(AuthDTO authDTO) {
        Person person = modelMapper.map(authDTO, Person.class);
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setCreatedAt(LocalDateTime.now());
        person.setUpdatedAt(LocalDateTime.now());
        person.setRole("ROLE_USER");
        person.setCreatedWho("ADMIN");
        peopleRepository.save(person);
    }
}