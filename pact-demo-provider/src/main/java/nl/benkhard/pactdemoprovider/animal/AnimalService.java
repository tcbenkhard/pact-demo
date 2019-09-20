package nl.benkhard.pactdemoprovider.animal;

import nl.benkhard.pactdemoprovider.ResourceNotFoundException;
import nl.benkhard.pactdemoprovider.domain.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    public Animal findByName(String name) {
        Animal animal = repository.findByName(name);
        if (animal == null) throw new ResourceNotFoundException();

        return animal;
    }

    public Iterable<Animal> findAll() {
        return repository.findAll();
    }
}
