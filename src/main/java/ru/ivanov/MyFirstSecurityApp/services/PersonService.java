package ru.ivanov.MyFirstSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ivanov.MyFirstSecurityApp.models.Person;
import ru.ivanov.MyFirstSecurityApp.repositories.PeopleRepository;

import java.util.Optional;

@Service
public class PersonService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonService(PeopleRepository peopleRepository) {

        this.peopleRepository = peopleRepository;
    }

    public Optional<Person> findByName(String name) {

        return peopleRepository.findByUsername(name);

    }
}
