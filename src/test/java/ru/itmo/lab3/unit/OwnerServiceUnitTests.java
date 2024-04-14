package ru.itmo.lab3.unit;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.itmo.CatService;
import ru.itmo.OwnerService;
import ru.itmo.models.Cat;
import ru.itmo.models.Colors;
import ru.itmo.models.Owner;
import ru.itmo.repositories.CatRepository;
import ru.itmo.repositories.OwnerRepository;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OwnerServiceUnitTests {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerService ownerService;

    @Test
    public void testGetOwnerById() {
        Owner owner = new Owner();
        owner.setId(1);
        owner.setName("Test Owner");
        owner.setBirthdate(LocalDate.now());

        when(ownerRepository.findById(1)).thenReturn(Optional.of(owner));

        Owner result = ownerService.findById(1);

        assertEquals(owner, result);

        verify(ownerRepository, times(1)).findById(1);
    }

    @Test
    public void testGetOwnerByName() {
        Owner owner = new Owner();
        owner.setId(1);
        owner.setName("Test Owner");
        owner.setBirthdate(LocalDate.now());

        when(ownerRepository.findByName("Test owner")).thenReturn(Optional.of(owner));

        Owner result = ownerService.getByName("Test owner");

        assertEquals(owner, result);
    }
}
