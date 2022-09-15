package com.dkharchenko_hillel.homework4.reposiroties;

import com.dkharchenko_hillel.homework4.models.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Modifying
    @Query("update Person set firstName = ?2 where id = ?1")
    Integer updatePersonFirstNameById(Long id, String firstName);
    @Modifying
    @Query("update Person set lastName = ?2 where id = ?1")
    Integer updatePersonLastNameById(Long id, String lastName);
    @Modifying
    @Query("update Person set phoneNumber = ?2 where id = ?1")
    Integer updatePersonPhoneNumberById(Long id, String phoneNumber);
}
