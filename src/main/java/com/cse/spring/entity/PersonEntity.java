package com.cse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

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
public class PersonEntity extends BaseEntity {

    private String name;
    @NotEmpty(message = "Value must not be empty")
    @Min(value = 0, message = "Age value must not be negative")
    private int age;
    private boolean isLegal;
}
