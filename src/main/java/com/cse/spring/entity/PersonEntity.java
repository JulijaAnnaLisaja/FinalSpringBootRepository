package com.cse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import static com.cse.spring.util.Constant.PERSON;

/**
 * Person Entity definition.
 *
 * @author julija.anna.lisaja@accenture.com
 */
@Entity(name = PERSON)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Min(value = 0, message = "Age value must not be negative")
    private int age;
    private boolean isLegal;
}
