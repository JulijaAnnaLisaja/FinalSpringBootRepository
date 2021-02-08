package com.cse.spring.controller;

import com.cse.spring.entity.PersonEntity;
import com.cse.spring.service.PersonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static com.cse.spring.util.CommonUtil.getPerson_Ivan;
import static com.cse.spring.util.CommonUtil.getPerson_Olga;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Person Controller Integration Test Class definition.
 *
 * @author julija.anna.lisaja@accenture.com
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonServiceImpl personService;

    @Test
    public void getAllPersonsWhenListOfPersonsIsEmpty() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/get");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals(personService.getAllPersons().toString(), result.getResponse().getContentAsString());
    }
}
