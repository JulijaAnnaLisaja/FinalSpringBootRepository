package com.cse.spring.service;

import com.cse.spring.entity.PersonEntity;
import com.cse.spring.exception.response.CustomizedNotFoundException;
import com.cse.spring.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.cse.spring.util.CommonUtil.EXPECTED_ID_1;
import static com.cse.spring.util.CommonUtil.EXPECTED_ID_2;
import static com.cse.spring.util.CommonUtil.EXPECTED_NAME_OLGA;
import static com.cse.spring.util.CommonUtil.getPerson_Ivan;
import static com.cse.spring.util.CommonUtil.getPerson_Olga;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Person Service test class definition.
 *
 * @author julija.anna.lisaja@accenture.com
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @MockBean
    private PersonRepository personRepository;

    private static final Logger logger = LogManager.getLogger(PersonServiceTest.class);

    @Test
    public void testGetAllPersons() throws CustomizedNotFoundException {

        // Crete person Ivan
        PersonEntity personIvan = getPerson_Ivan();

        // Crete person Olga
        PersonEntity personOlga = getPerson_Olga();

        List<PersonEntity> personsList = new ArrayList<>();

        personsList.add(personIvan);
        personsList.add(personOlga);

        Mockito.when(personRepository.findAllPersons()).thenReturn(personsList);
        assertThat(personService.getAllPersons()).isEqualTo(personsList);
    }

    @Test
    public void testGetAllPersons_NoPersonFound() throws CustomizedNotFoundException {

        List<PersonEntity> personsList = new ArrayList<>();

        logger.debug("Person list: {}", personsList);

        Mockito.when(personRepository.findAllPersons()).thenThrow(CustomizedNotFoundException.class);
        assertThrows(CustomizedNotFoundException.class, () -> personService.getAllPersons());
    }

    @Test
    public void testGetOnePersonById() throws CustomizedNotFoundException {

        PersonEntity person = getPerson_Ivan();
        person.setId(EXPECTED_ID_1);

        Optional<PersonEntity> optionalPerson = Optional.of(person);

        logger.debug("Person id: {}", optionalPerson.get().getId());

        Mockito.when(personRepository.findPersonById(EXPECTED_ID_1)).thenReturn(optionalPerson);
        assertThat(personService.getPersonById(EXPECTED_ID_1)).isEqualTo(optionalPerson.get());
    }

    @Test
    public void testGetOnePersonById_NotFound() {

        PersonEntity person = getPerson_Ivan();
        person.setId(EXPECTED_ID_1);

        Optional<PersonEntity> optionalPerson = Optional.of(person);

        logger.debug("Person id: {}", optionalPerson.get().getId());

        Mockito.when(personRepository.findById(EXPECTED_ID_2)).thenThrow(CustomizedNotFoundException.class);
        assertThrows(CustomizedNotFoundException.class, () -> personService.getPersonById(EXPECTED_ID_2));
    }

    @Test
    public void testCreatePerson() {

        PersonEntity person = getPerson_Ivan();
        person.setId(EXPECTED_ID_1);

        logger.debug("Person : {}", person);
        logger.debug("Repository result: {}", personRepository.save(person));
        logger.debug("Service result : {}", personService.createPerson(person));

        Mockito.when(personRepository.save(person)).thenReturn(person);
        assertThat(personService.createPerson(person)).isEqualTo(person);
    }

    @Test
    public void testUpdateExistingPerson() throws CustomizedNotFoundException {
        PersonEntity person = getPerson_Ivan();
        person.setId(EXPECTED_ID_1);

        Optional<PersonEntity> optionalPerson = Optional.of(person);
        Mockito.when(personRepository.findPersonById(EXPECTED_ID_1)).thenReturn(optionalPerson);

        optionalPerson.get().setName(EXPECTED_NAME_OLGA);

        Mockito.when(personRepository.findPersonById(EXPECTED_ID_1)).thenReturn(optionalPerson);

        logger.debug("Compared result : {} {}",
                personService.getPersonById(EXPECTED_ID_1).getName(), EXPECTED_NAME_OLGA);

        assertThat(personService.getPersonById(EXPECTED_ID_1).getName()).isEqualTo(EXPECTED_NAME_OLGA);

    }

    @Test
    public void testDeletePerson() {

        PersonEntity person = getPerson_Ivan();
        person.setId(EXPECTED_ID_1);

        Mockito.when(personRepository.findPersonById(EXPECTED_ID_1)).thenReturn(Optional.of(person));
        Mockito.when(personRepository.existsById(person.getId())).thenReturn(false);

        assertFalse(personRepository.existsById(person.getId()));
    }
}
