package org.example.service;

import org.example.data.Person;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class PeopleService {
    Map<Long, Person> personMap = new HashMap<>();
    AtomicLong ctr = new AtomicLong();

    public Person addPerson(Person person) {
        if (person.getId() == null) {
            person.setId(ctr.incrementAndGet());
        }

        personMap.put(person.getId(), person);
        return person;
    }

    public void deletePerson(Long id) {
        personMap.remove(id);
    }

    public Collection<Person> getPersons()  {
        return personMap.values();
    }

    public Person getPerson(Long id) {
        return personMap.get(id);
    }

}
