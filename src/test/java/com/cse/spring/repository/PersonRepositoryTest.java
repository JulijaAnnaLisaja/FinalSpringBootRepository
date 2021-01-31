package com.cse.spring.repository;

import com.cse.spring.entity.PersonEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Validation;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import static com.cse.spring.util.CommonUtil.EXPECTED_NAME_OLGA;
import static com.cse.spring.util.CommonUtil.getPerson_Ivan;
import static com.cse.spring.util.CommonUtil.getPerson_Olga;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertFalse;

/**
 * Person Repository test class definition.
 *
 * @author julija.anna.lisaja@accenture.com
 */
@DataJpaTest
public class PersonRepositoryTest {

    private static final Logger logger = LogManager.getLogger(PersonRepositoryTest.class);

    @Autowired
    private TestEntityManager entityManager;

    private Validation validation;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testGetOnePersonById() {

        PersonEntity person = getPerson_Ivan();
        PersonEntity savedPersonInDB = entityManager.persist(person);

        PersonEntity getPersonFromDB = personRepository.getOne(savedPersonInDB.getId());

        logger.debug("Entity saved in database : {}", savedPersonInDB);
        logger.debug("Compared entity : {}", getPersonFromDB);

        assertThat(savedPersonInDB).isEqualTo(getPersonFromDB);
    }

    @Test
    public void testGetAllPersons() {

        PersonEntity personIvan = getPerson_Ivan();
        PersonEntity personOleg = getPerson_Olga();

        entityManager.persist(personIvan);
        entityManager.persist(personOleg);

        List<PersonEntity> allEmployeeFromDB = personRepository.findAll();
        List<PersonEntity> personList = new ArrayList<>();

        for (PersonEntity e : allEmployeeFromDB) personList.add(e);

        logger.debug("Entity size : {}", personList.size());

        assertThat(personList.size()).isEqualTo(2);
    }

    @Test
    public void testSavePerson() {

        PersonEntity person = getPerson_Ivan();

        PersonEntity savedPersonInDB = entityManager.persist(person);
        PersonEntity getPersonFromDB = personRepository.findById(savedPersonInDB.getId()).get();

        logger.debug("Entity saved in database : {}", savedPersonInDB);
        logger.debug("Compared entity : {}", getPersonFromDB);

        assertThat(getPersonFromDB).isEqualTo(savedPersonInDB);

    }

    @Test
    public void testSavePerson_NegativeAgeException() {

        PersonEntity person = getPerson_Ivan();
        person.setAge(-1);

        assertThrows(ConstraintViolationException.class, () -> entityManager.persist(person));

    }

    @Test
    public void testDeletePerson() {

        PersonEntity personIvan = getPerson_Ivan();
        PersonEntity personOlga = getPerson_Olga();

        PersonEntity personEntity = entityManager.persist(personIvan);
        entityManager.persist(personOlga);

        personRepository.deleteById(personEntity.getId());

        Iterable<PersonEntity> allEmployeeFromDB = personRepository.findAll();
        List<PersonEntity> personList = new ArrayList<>();

        for (PersonEntity e : allEmployeeFromDB) personList.add(e);

        logger.debug("Person List size: {}", personList.size());

        assertThat(personList.size()).isEqualTo(1);
    }

    @Test
    public void testUpdatePerson() {

        PersonEntity person = getPerson_Ivan();

        PersonEntity personSaved = entityManager.persist(person);

        logger.debug("Person saved name: {}", person.getName());

        personSaved.setName(EXPECTED_NAME_OLGA);
        entityManager.persist(personSaved);
        PersonEntity getPersonFromDB = personRepository.getOne(personSaved.getId());

        logger.debug("Person saved name: {}", getPersonFromDB.getName());
        assertThat(getPersonFromDB.getName()).isEqualTo(EXPECTED_NAME_OLGA);
    }

}
