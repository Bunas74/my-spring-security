package org.example.myspringsecurity.service;

import java.util.List;
import java.util.Optional;
import org.example.myspringsecurity.model.Person;

public interface PeopleService {

    Optional<Person> findByUsername(String username);

    List<Person> findAll();
}