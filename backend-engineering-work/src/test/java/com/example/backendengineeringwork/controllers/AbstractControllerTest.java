package com.example.backendengineeringwork.controllers;

import com.example.backendengineeringwork.dummy.TestEntity;
import com.example.backendengineeringwork.dummy.TestService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.http.RequestEntity.put;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AbstractControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestService testService;

    @Test
    public void testGetAll() throws Exception {
        TestEntity entity = new TestEntity();
        entity.setId(1L);
        entity.setName("TestName");

        when(testService.findAll()).thenReturn(List.of(entity));

        mockMvc.perform(get("/test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("TestName")));
    }

    @Test
    public void testCreate() throws Exception {
        TestEntity entity = new TestEntity();
        entity.setName("TestName");

        when(testService.save(any(TestEntity.class))).thenReturn(entity);

        mockMvc.perform(post("/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType("{\"name\":\"TestName\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("TestName")));
    }

    @Test
    public void testUpdate() throws Exception {
        TestEntity entity = new TestEntity();
        entity.setId(1L);
        entity.setName("UpdatedName");

        when(testService.findById(1L)).thenReturn(Optional.of(entity));
        when(testService.save(any(TestEntity.class))).thenReturn(entity);

        mockMvc.perform(put("/test/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"UpdatedName\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("UpdatedName")));
    }

    @Test
    public void testDelete() throws Exception {
        TestEntity entity = new TestEntity();
        entity.setId(1L);
        entity.setName("TestName");

        when(testService.findById(1L)).thenReturn(Optional.of(entity));

        mockMvc.perform(delete("/test/1"))
                .andExpect(status().isOk());

        verify(testService, times(1)).deleteById(1L);
    }
}
