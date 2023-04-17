package ir.bigz.spring.codecoverage;

import ir.bigz.spring.codecoverage.jacoco.view.ItemRequest;
import ir.bigz.spring.codecoverage.jacoco.view.ItemResponse;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@SpringBootTest(classes = CodeCoverageApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ItemControllerIT {

    @LocalServerPort
    private int randomPort;
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl;
    private URI uri;

    @BeforeAll
    void setUp() {
        baseUrl = "http://localhost:" + randomPort + "/api/item";
    }

    @Test
    public void add_item_by_controller() throws URISyntaxException {

        //given
        ItemRequest itemRequest = new ItemRequest("sony IV",
                "mobile",
                10,
                new BigDecimal("10.000"));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
        HttpEntity<ItemRequest> entity = new HttpEntity<>(itemRequest, httpHeaders);

        //then
        baseUrl = baseUrl + "/v1";
        URI uri = new URI(baseUrl);
        ResponseEntity<ItemResponse> response = restTemplate.exchange(uri, HttpMethod.POST, entity, ItemResponse.class);

        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
        Assertions.assertTrue(Objects.nonNull(response.getBody()) && !response.getBody().getId().equals(""));
    }
}
