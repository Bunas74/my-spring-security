package org.example.myspringsecurity.util;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.myspringsecurity.dto.AuthDTO;
import org.example.myspringsecurity.model.Person;
import org.example.myspringsecurity.service.impl.PeopleServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class PersonValidator implements Validator {

    private final PeopleServiceImpl peopleService;

    @Override
    public boolean supports(Class<?> clazz) {
        return AuthDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AuthDTO personDTO = (AuthDTO) target;
        Optional<Person> existsPerson = peopleService.findByUsername(personDTO.getUsername());
        if (existsPerson.isPresent()) {
            errors.rejectValue("username", "", "Человек с таким именем уже существует");
        }
    }
}
