package org.example.myspringsecurity.service.impl;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.myspringsecurity.model.Person;
import org.example.myspringsecurity.repository.PeopleRepository;
import org.example.myspringsecurity.service.PeopleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService {

    private final PeopleRepository peopleRepository;

    public Optional<Person> findByUsername(String username) {
        return peopleRepository.findByUsername(username);
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }
}