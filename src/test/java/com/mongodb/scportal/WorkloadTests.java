package com.mongodb.scportal;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.scportal.model.Workload;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;

import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest

public class WorkloadTests {
    private final ObjectMapper objectMapper = new ObjectMapper();
    String createWorkloadUrl = "http://localhost:8080/createWorkload";
    String updateWorkloadUrl = "http://localhost:8080/updateWorkload";
    static HttpHeaders headers = new HttpHeaders();

    @BeforeClass
    public static void runBeforeAllTestMethods() throws JSONException {

        RestTemplate restTemplate = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject workloadJsonObject = new JSONObject();
        workloadJsonObject.put("id", 1);
        workloadJsonObject.put("name", "John");
    }

    @Test
    public void givenDataIsJson_whenDataIsPostedByPostForEntity_thenResponseBodyIsNotNull()
            throws IOException {
        Workload workload = new Workload();
        HttpEntity<String> request =
                new HttpEntity<String>(workload.toString(), headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntityStr = restTemplate.postForEntity(createWorkloadUrl, request, String.class);
        JsonNode root = objectMapper.readTree(responseEntityStr.getBody());

        assertNotNull(responseEntityStr.getBody());
        assertNotNull(root.path("name").asText());
    }

}
