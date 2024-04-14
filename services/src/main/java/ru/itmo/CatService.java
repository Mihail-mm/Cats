package ru.itmo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.models.Cat;
import ru.itmo.models.Colors;
import ru.itmo.models.Owner;
import ru.itmo.repositories.CatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CatService {
    private CatRepository catRepository;

    @Autowired
    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    public Cat findById(int id) {
        Optional<Cat> cat = catRepository.findById(id);
        return cat.orElse(null);
    }

    public List<Cat> findByColor(Colors color) {
        Optional<List<Cat>> cats = catRepository.findCatsByColor(color);
        return cats.orElse(null);
    }

    public List<Cat> findByBreed(String breed) {
        Optional<List<Cat>> cats = catRepository.findCatsByBreed(breed);
        return cats.orElse(null);
    }

    public Cat findByName(String name) {
        return catRepository.findCatByName(name).orElse(null);
    }

    @Transactional
    public void save(Cat cat) {
        catRepository.save(cat);
    }

    @Transactional
    public void delete(int id) {
        catRepository.deleteById(id);
    }

    public Owner getCatOwner(int id) {
        return catRepository.findById(id).map(Cat::getOwner).orElse(null);
    }
}
