package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.dummy.TestEntity;
import com.example.backendengineeringwork.dummy.TestRepository;
import com.example.backendengineeringwork.dummy.TestService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbstractServiceTest {

    @Autowired
    private TestService testService;

    @MockBean
    private TestRepository testRepository;

    @Test
    public void testFindAll() {
        TestEntity entity = new TestEntity();
        entity.setId(1L);
        entity.setName("TestName");

        when(testRepository.findAll()).thenReturn(List.of(entity));

        List<TestEntity> results = testService.findAll();

        assertEquals(1, results.size());
        assertEquals("TestName", results.get(0).getName());
    }

    @Test
    public void testCreate() {
        TestEntity entity = new TestEntity();
        entity.setName("TestName");

        when(testRepository.save(any(TestEntity.class))).thenReturn(entity);

        TestEntity savedEntity = testService.save(entity);

        assertEquals("TestName", savedEntity.getName());
    }

    @Test
    public void testUpdate() {
        TestEntity existingEntity = new TestEntity();
        existingEntity.setId(1L);
        existingEntity.setName("OriginalName");

        TestEntity updatedEntity = new TestEntity();
        updatedEntity.setId(1L);
        updatedEntity.setName("UpdatedName");

        when(testRepository.findById(1L)).thenReturn(Optional.of(existingEntity));
        when(testRepository.save(any(TestEntity.class))).thenReturn(updatedEntity);

        TestEntity result = testService.save(updatedEntity);

        assertEquals("UpdatedName", result.getName());
    }

    @Test
    public void testDelete() {
        TestEntity entity = new TestEntity();
        entity.setId(1L);
        entity.setName("TestName");

        when(testRepository.findById(1L)).thenReturn(Optional.of(entity));

        testService.deleteById(1L);

        verify(testRepository, times(1)).deleteById(1L);
    }
}