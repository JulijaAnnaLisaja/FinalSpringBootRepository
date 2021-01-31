package com.cse.spring.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

/**
 * Common value for any Entity definition.
 *
 * @author julija.anna.lisaja@accenture.com
 */
@MappedSuperclass
@EqualsAndHashCode
@Getter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private final LocalDate creationDate = LocalDate.now();
}
