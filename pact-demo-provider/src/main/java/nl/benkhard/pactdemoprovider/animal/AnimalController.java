package nl.benkhard.pactdemoprovider.animal;

import nl.benkhard.pactdemoprovider.domain.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

    @Autowired
    private AnimalService service;

    @GetMapping(value = "/animals", params = "name")
    public Animal findByName(@RequestParam(value = "name", required = false) String name) {
        return service.findByName(name);
    }

    @GetMapping("/animals")
    public Iterable<Animal> findAll() {
        return service.findAll();
    }
}
