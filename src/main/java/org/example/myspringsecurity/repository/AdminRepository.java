package org.example.myspringsecurity.repository;

import org.example.myspringsecurity.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Person, Long> {
}