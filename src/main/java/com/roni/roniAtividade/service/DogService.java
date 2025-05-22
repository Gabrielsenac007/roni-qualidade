package com.roni.roniAtividade.service;

import com.roni.roniAtividade.dto.DogDto;
import com.roni.roniAtividade.entity.Dog;
import com.roni.roniAtividade.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;


    public List<Dog> getAllDogs(){
        return dogRepository.findAll();
    }

    public String insertDog(DogDto data){
        Dog newDog = new Dog(data.name(), data.age(), data.race());
        dogRepository.save(newDog);
        return "Dog criado com sucesso!";
    }


}
