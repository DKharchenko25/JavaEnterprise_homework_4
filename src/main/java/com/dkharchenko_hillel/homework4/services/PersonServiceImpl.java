package com.dkharchenko_hillel.homework4.services;

import com.dkharchenko_hillel.homework4.NotFoundException;
import com.dkharchenko_hillel.homework4.dtos.PersonDto;
import com.dkharchenko_hillel.homework4.models.Person;
import com.dkharchenko_hillel.homework4.reposiroties.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Long addPerson(PersonDto dto) {
        return personRepository.save(new Person(dto.getFirstName(), dto.getLastName(), dto.getPhoneNumber())).getId();
    }

    @Override
    public Long removePersonById(Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return id;
        }
        try {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Person getPersonById(Long id) {
        if (personRepository.findById(id).isPresent()) {
            return personRepository.findById(id).get();
        }
        try {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Long updatePersonFirstNameById(Long id, PersonDto dto) {
        if (personRepository.existsById(id)) {
            return Long.valueOf(personRepository.updatePersonFirstNameById(id, dto.getFirstName()));
        }
        try {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Long updatePersonLastNameById(Long id, PersonDto dto) {
        if (personRepository.existsById(id)) {
            return Long.valueOf(personRepository.updatePersonLastNameById(id, dto.getLastName()));
        }
        try {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Long updatePersonPhoneNumberById(Long id, PersonDto dto) {
        if (personRepository.existsById(id)) {
            return Long.valueOf(personRepository.updatePersonPhoneNumberById(id, dto.getPhoneNumber()));
        }
        try {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
