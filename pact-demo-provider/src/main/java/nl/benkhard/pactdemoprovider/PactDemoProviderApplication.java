package nl.benkhard.pactdemoprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("nl.benkhard.pactdemoprovider.domain")
@SpringBootApplication
public class PactDemoProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PactDemoProviderApplication.class, args);
    }
}

