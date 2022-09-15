package com.dkharchenko_hillel.homework4.services;

import com.dkharchenko_hillel.homework4.dtos.PersonDto;
import com.dkharchenko_hillel.homework4.models.Person;

import java.util.List;

public interface PersonService {
    Long addPerson(PersonDto dto);

    Long removePersonById(Long id);

    Person getPersonById(Long id);

    List<Person> getAllPersons();

    Long updatePersonFirstNameById(Long id, PersonDto dto);

    Long updatePersonLastNameById(Long id, PersonDto dto);

    Long updatePersonPhoneNumberById(Long id, PersonDto dto);
}
