package com.cse.spring.util;

import com.cse.spring.entity.PersonEntity;

public class CommonUtil {

    public static final int EXPECTED_ID_1 = 1;
    public static final String EXPECTED_NAME_IVAN = "Ivan";
    public static final int EXPECTED_AGE_22 = 22;
    public static final boolean EXPECTED_IS_LEGAL_TRUE = true;

    public static final int EXPECTED_ID_2 = 2;
    public static final String EXPECTED_NAME_OLGA = "Olga";
    public static final int EXPECTED_AGE_17 = 17;
    public static final boolean EXPECTED_IS_LEGAL_FALSE = false;

    public static final PersonEntity person = new PersonEntity(EXPECTED_ID_1, EXPECTED_NAME_IVAN, EXPECTED_AGE_22, EXPECTED_IS_LEGAL_TRUE);

    public static PersonEntity getPerson_Ivan() {

        PersonEntity person = new PersonEntity();
        person.setName(EXPECTED_NAME_IVAN);
        person.setLegal(EXPECTED_IS_LEGAL_TRUE);
        person.setAge(EXPECTED_AGE_22);
        return person;
    }

    public static PersonEntity getPerson_Olga() {

        PersonEntity person = new PersonEntity();
        person.setName(EXPECTED_NAME_OLGA);
        person.setLegal(EXPECTED_IS_LEGAL_FALSE);
        person.setAge(EXPECTED_AGE_17);
        return person;
    }
}
