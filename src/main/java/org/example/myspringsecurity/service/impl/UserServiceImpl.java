package org.example.myspringsecurity.service.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.myspringsecurity.model.Person;
import org.example.myspringsecurity.repository.PeopleRepository;
import org.example.myspringsecurity.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PeopleRepository peopleRepository;

    public Optional<Person> findById(long id) {
        return peopleRepository.findById(id);
    }
}