package com.cse.spring.service;

import com.cse.spring.entity.PersonEntity;
import com.cse.spring.exception.response.CustomizedNotFoundException;

import java.util.List;

/**
 * Person Service interface definition.
 *
 * @author julija.anna.lisaja@accenture.com
 */
public interface PersonService {

    /**
     * Get all persons from H2 database.
     *
     * @return all Person records.
     */
    List<PersonEntity> getAllPersons() throws CustomizedNotFoundException;

    /**
     * Find one Person in H2 database by its unique id.
     *
     * @return person by id.
     */
    PersonEntity getPersonById(Integer id) throws CustomizedNotFoundException;

    /**
     * Creates new Person record in H2 database.
     *
     * @return person by id.
     */
    PersonEntity createPerson(PersonEntity personEntity);

    /**
     * Update one dedicates person in the database by its unique id.
     *
     * @return person by id.
     */
    PersonEntity updatePersonById(PersonEntity personEntity, Integer id) throws CustomizedNotFoundException;

    /**
     * Delete one dedicates person in the database by its unique id.
     */
    void deletePersonById(Integer id) throws CustomizedNotFoundException;

}
