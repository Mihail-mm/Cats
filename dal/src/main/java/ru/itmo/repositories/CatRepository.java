package ru.itmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.models.Cat;
import ru.itmo.models.Colors;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {
    Optional<Cat> findCatByName(String name);
    Optional<List<Cat>> findCatsByColor(Colors color);
    Optional<List<Cat>> findCatsByBreed(String breed);
}