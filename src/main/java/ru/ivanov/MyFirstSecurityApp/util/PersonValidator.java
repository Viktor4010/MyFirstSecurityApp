package ru.ivanov.MyFirstSecurityApp.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ivanov.MyFirstSecurityApp.models.Person;
import ru.ivanov.MyFirstSecurityApp.services.PersonService;

@Component
public class PersonValidator implements Validator {

    private final PersonService personService;

    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Person person = (Person) target;

        if (personService.findByName(person.getUsername()).isPresent())
            errors.rejectValue("username", "","Person with such name is already defined");

    }
}
