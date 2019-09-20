package nl.benkhard.pactdemoprovider;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import nl.benkhard.pactdemoprovider.domain.Animal;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TestPact {

    @Rule
    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("animalProvider", "localhost", 8081, this);

    @Pact(provider = "animalProvider", consumer = "animalConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");

        DslPart bodyMatcher = PactDslJsonArray.arrayEachLike()
                .id()
                .stringType("name")
                .booleanType("mammal")
                .closeObject();

        return builder
                .uponReceiving("GET a list of animals")
                .path("/animals")
                .method("GET")
                .willRespondWith()
                .body(bodyMatcher)
                .status(200)
                .toPact();
    }

    @Test
    @PactVerification("animalProvider")
    public void runTest() {
        given()
                .baseUri("http://localhost").port(8081)
                .get("/animals");
        assertEquals(1, 1);
    }
}
