package ru.itmo.lab3.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.itmo.CatService;
import ru.itmo.models.Cat;
import ru.itmo.models.Colors;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CatServiceIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CatService catService;

    @Test
    public void testGetCatById() throws Exception {
        Cat cat = new Cat();
        cat.setName("Test Cat");
        cat.setBirthdate(LocalDate.now());
        cat.setBreed("Test Breed");
        cat.setColor(Colors.BLACK);
        catService.save(cat);

        mockMvc.perform(MockMvcRequestBuilders.get("/cats/" + cat.getId()))
                .andExpect(status().isOk());
    }
}