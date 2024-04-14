package ru.itmo.lab3.unit;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.itmo.CatService;
import ru.itmo.models.Cat;
import ru.itmo.models.Colors;
import ru.itmo.repositories.CatRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CatServiceUnitTests {

    @Mock
    private CatRepository catRepository;

    @InjectMocks
    private CatService catService;

    @Test
    public void testGetCatById() {
        Cat cat = new Cat();
        cat.setId(1);
        cat.setName("Test Cat");
        cat.setBirthdate(LocalDate.now());
        cat.setBreed("Test Breed");
        cat.setColor(Colors.BLACK);

        when(catRepository.findById(1)).thenReturn(Optional.of(cat));

        Cat result = catService.findById(1);

        assertEquals(cat, result);

        verify(catRepository, times(1)).findById(1);
    }

    @Test
    public void testGetCatByName() {
        Cat cat = new Cat();
        cat.setId(1);
        cat.setName("Test Cat");
        cat.setBirthdate(LocalDate.now());
        cat.setBreed("Test Breed");
        cat.setColor(Colors.BLACK);

        when(catRepository.findCatByName("Test Cat")).thenReturn(Optional.of(cat));

        Cat result = catService.findByName("Test Cat");

        assertEquals(cat, result);
    }

    @Test
    public void testGetCatsByColor() {
        Cat cat1 = new Cat();
        cat1.setId(1);
        cat1.setName("1");
        cat1.setBirthdate(LocalDate.now());
        cat1.setBreed("1");
        cat1.setColor(Colors.red);

        Cat cat2 = new Cat();
        cat1.setId(2);
        cat1.setName("2");
        cat1.setBirthdate(LocalDate.now());
        cat1.setBreed("2");
        cat1.setColor(Colors.red);

        Cat cat3 = new Cat();
        cat1.setId(3);
        cat1.setName("3");
        cat1.setBirthdate(LocalDate.now());
        cat1.setBreed("3");
        cat1.setColor(Colors.BLACK);


        when(catRepository.findCatsByColor(Colors.red)).thenReturn(Optional.of(List.of(cat1, cat2)));
        List<Cat> result = catService.findByColor(Colors.red);

        assertEquals(List.of(cat1, cat2), result);
    }

    @Test
    public void testGetCatsByBreed() {
        Cat cat1 = new Cat();
        cat1.setId(1);
        cat1.setName("1");
        cat1.setBirthdate(LocalDate.now());
        cat1.setBreed("1");
        cat1.setColor(Colors.red);

        Cat cat2 = new Cat();
        cat1.setId(2);
        cat1.setName("2");
        cat1.setBirthdate(LocalDate.now());
        cat1.setBreed("1");
        cat1.setColor(Colors.red);

        Cat cat3 = new Cat();
        cat1.setId(3);
        cat1.setName("3");
        cat1.setBirthdate(LocalDate.now());
        cat1.setBreed("1");
        cat1.setColor(Colors.BLACK);


        when(catRepository.findCatsByBreed("1")).thenReturn(Optional.of(List.of(cat1, cat2, cat3)));
        List<Cat> result = catService.findByBreed("1");

        assertEquals(List.of(cat1, cat2, cat3), result);
    }

    @Test
    public void testGetAllCats() {
        Cat cat1 = new Cat();
        cat1.setId(1);
        cat1.setName("1");
        cat1.setBirthdate(LocalDate.now());
        cat1.setBreed("1");
        cat1.setColor(Colors.red);

        Cat cat2 = new Cat();
        cat1.setId(2);
        cat1.setName("2");
        cat1.setBirthdate(LocalDate.now());
        cat1.setBreed("1");
        cat1.setColor(Colors.red);

        Cat cat3 = new Cat();
        cat1.setId(3);
        cat1.setName("3");
        cat1.setBirthdate(LocalDate.now());
        cat1.setBreed("1");
        cat1.setColor(Colors.BLACK);


        when(catRepository.findAll()).thenReturn(List.of(cat1, cat2, cat3));
        List<Cat> result = catService.findAll();

        assertEquals(List.of(cat1, cat2, cat3), result);
    }
}