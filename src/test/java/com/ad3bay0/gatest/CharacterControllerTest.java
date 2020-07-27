package com.ad3bay0.gatest;

import com.ad3bay0.gatest.repositories.CharacterRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = CharacterControllerTest.class)
public class CharacterControllerTest {

    @MockBean
    private CharacterRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void checkSortingParams() throws Exception{

        mockMvc.perform(get("/characters")
        .param("sort", "gender, desc")
        .param("sort", "firstName, asc")
        .param("sort", "lastName, desc"));


    }
    
}