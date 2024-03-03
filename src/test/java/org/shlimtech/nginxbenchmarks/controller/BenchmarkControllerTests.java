package org.shlimtech.nginxbenchmarks.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.shlimtech.nginxbenchmarks.dto.NameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {"server.tomcat.threads.max=1"})
public class BenchmarkControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    public void dateTest() {
        mockMvc.perform(get("/date")).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void nameTest() {
        mockMvc.perform(post("/name")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new NameDTO("comintern"))))
                .andExpect(status().isOk());
    }

}
