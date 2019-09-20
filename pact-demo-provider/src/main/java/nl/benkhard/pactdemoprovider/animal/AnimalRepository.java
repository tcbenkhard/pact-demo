package nl.benkhard.pactdemoprovider.animal;

import nl.benkhard.pactdemoprovider.domain.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {

    public Animal findByName(String name);

}