package com.cse.spring.component;

import com.cse.spring.entity.PersonEntity;
import com.cse.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CommandLineRunnerComponent class definition.
 *
 * @author julija.anna.lisaja@accenture.com
 */
@Component
public class CommandLineRunnerComponent implements CommandLineRunner {

    private final PersonService personService;

    @Autowired
    public CommandLineRunnerComponent(PersonService personService) {
        this.personService = personService;
    }

    private static final List<PersonEntity> persons = new ArrayList<>(Arrays.asList(
            new PersonEntity(1, "Ivan", 24, true),
            new PersonEntity(2, "Olga", 17, false),
            new PersonEntity(3, "Andrej", 33, true)
    ));

    @Override
    public void run(String... args) {
        for (PersonEntity person : persons)
            this.personService.createPerson(person);
    }
}
