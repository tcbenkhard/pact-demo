package nl.benkhard.pactdemoprovider;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(PactRunner.class)
@Provider("animalProvider")
@PactFolder("pacts")
public class ITPactRunner {

    @TestTarget // Annotation denotes Target that will be used for tests
    public final Target target = new HttpTarget(8080);
}
