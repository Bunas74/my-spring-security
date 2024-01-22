package org.example.myspringsecurity.service;

import lombok.RequiredArgsConstructor;
import org.example.myspringsecurity.model.Person;
import org.example.myspringsecurity.repository.PeopleRepository;
import org.example.myspringsecurity.security.PersonDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = this.peopleRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new PersonDetails(person);
    }
}