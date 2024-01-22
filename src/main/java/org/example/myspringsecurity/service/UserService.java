package org.example.myspringsecurity.service;

import java.util.Optional;
import org.example.myspringsecurity.model.Person;

public interface UserService {

    Optional<Person> findById(long id);
}