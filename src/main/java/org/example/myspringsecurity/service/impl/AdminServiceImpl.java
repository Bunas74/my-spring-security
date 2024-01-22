package org.example.myspringsecurity.service.impl;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.myspringsecurity.dto.EditDTO;
import org.example.myspringsecurity.model.Person;
import org.example.myspringsecurity.repository.AdminRepository;
import org.example.myspringsecurity.service.AdminService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    private final PasswordEncoder passwordEncoder;

    public Optional<Person> findById(long id) {
        return adminRepository.findById(id);
    }

    @Transactional
    public void updatePerson(EditDTO editDTO) {
        Person person = findById(editDTO.getId())
                .orElseThrow(() -> new NoSuchElementException("Person not found"));
        person.setUsername(editDTO.getUsername());
        person.setPassword(passwordEncoder.encode(editDTO.getPassword()));
        person.setRole(editDTO.getRole());
        person.setUpdatedAt(LocalDateTime.now());

        adminRepository.save(person);
    }

    @Transactional
    public void deletePerson(long id) {
        adminRepository.deleteById(id);
    }
}