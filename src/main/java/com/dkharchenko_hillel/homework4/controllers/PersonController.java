package com.dkharchenko_hillel.homework4.controllers;

import com.dkharchenko_hillel.homework4.dtos.PersonDto;
import com.dkharchenko_hillel.homework4.models.Person;
import com.dkharchenko_hillel.homework4.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Long> addPerson(@RequestBody PersonDto dto) {
        return new ResponseEntity<>(personService.addPerson(dto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove")
    @Transactional
    public ResponseEntity<Long> removePersonById(@RequestParam Long id) {
        return new ResponseEntity<>(personService.removePersonById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/person")
    public ResponseEntity<Person> getPersonById(@RequestParam Long id) {
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @PutMapping(value = "/update-first-name")
    @Transactional
    public ResponseEntity<Long> updatePersonFirstNameById(@RequestParam Long id, @RequestBody PersonDto dto) {
        return new ResponseEntity<>(personService.updatePersonFirstNameById(id, dto), HttpStatus.OK);
    }

    @PutMapping(value = "/update-last-name")
    @Transactional
    public ResponseEntity<Long> updatePersonLastNameById(@RequestParam Long id, @RequestBody PersonDto dto) {
        return new ResponseEntity<>(personService.updatePersonLastNameById(id, dto), HttpStatus.OK);
    }

    @PutMapping(value = "/update-phone-number")
    @Transactional
    public ResponseEntity<Long> updatePersonPhoneNumberById(@RequestParam Long id, @RequestBody PersonDto dto) {
        return new ResponseEntity<>(personService.updatePersonPhoneNumberById(id, dto), HttpStatus.OK);
    }
}
