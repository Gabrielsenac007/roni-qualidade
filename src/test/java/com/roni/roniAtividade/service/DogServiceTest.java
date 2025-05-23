package com.roni.roniAtividade.service;

import com.roni.roniAtividade.dto.DogDto;
import com.roni.roniAtividade.entity.Dog;
import com.roni.roniAtividade.repository.DogRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.configuration.IMockitoConfiguration;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


public class DogServiceTest {

    private DogRepository dogRepository;
    private DogService dogService;

    @BeforeEach
    void setup(){
        dogRepository = mock(DogRepository.class);
        dogService = new DogService(dogRepository);
    }

    @Test
    void testGetAllDogs(){
        List<Dog> fakeDogs = Arrays.asList(
                new Dog("Bob", 3, "Poodle"),
                new Dog("Luna", 2, "Labrador")
        );
        when(dogRepository.findAll()).thenReturn(fakeDogs);
        List<Dog> result = dogService.getAllDogs();
        Assertions.assertEquals("Bob", result.get(0).getName()); // ✅ Corrigido
        Assertions.assertEquals("Luna", result.get(1).getName()); // opcional, extra
        verify(dogRepository, times(1)).findAll();
    }

    @Test
    void testInsertDog() {
        // Arrange
        DogDto dto = new DogDto("Thor", 4, "Pitbull");

        // Act
        String result = dogService.insertDog(dto);

        // Assert
        Assertions.assertEquals("Dog criado com sucesso!", result);

        // Verifica se o objeto Dog foi salvo corretamente
        ArgumentCaptor<Dog> captor = ArgumentCaptor.forClass(Dog.class);
        verify(dogRepository).save(captor.capture());

        Dog savedDog = captor.getValue();
        Assertions.assertEquals("Thor", savedDog.getName());
        Assertions.assertEquals(4, savedDog.getAge());
        Assertions.assertEquals("Pitbull", savedDog.getRace());
    }

}
