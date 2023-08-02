package org.example.controller;

import org.example.data.Person;
import org.example.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
public class PersonController {
    @Autowired
    PeopleService peopleService;

    @PostMapping(value = "person", consumes = {"application/json"})
    public Person addPerson(@RequestBody Person person) {
        return peopleService.addPerson(person);
    }

    @DeleteMapping(value = "person")
    public void deletePerson(Long id) {
        peopleService.deletePerson(id);
    }

    @GetMapping(value = "person")
    public Collection<Person> getPerson(Long id) {
        if (id == null) {
            return peopleService.getPersons();
        }
        return List.of(peopleService.getPerson(id));
    }
}
