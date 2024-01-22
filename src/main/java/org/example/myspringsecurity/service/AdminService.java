package org.example.myspringsecurity.service;

import java.util.Optional;
import org.example.myspringsecurity.dto.EditDTO;
import org.example.myspringsecurity.model.Person;

public interface AdminService {

    Optional<Person> findById(long id);

    void updatePerson(EditDTO editDTO);

    void deletePerson(long id);
}
