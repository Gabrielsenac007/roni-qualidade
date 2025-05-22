package com.roni.roniAtividade.controller;

import com.roni.roniAtividade.dto.DogDto;
import com.roni.roniAtividade.entity.Dog;
import com.roni.roniAtividade.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dog")
public class DogController {

    @Autowired
    private DogService dogService;

    @PostMapping("/insertDog")
    public ResponseEntity<String> insertDog(@RequestBody DogDto data){
       return ResponseEntity.status(HttpStatus.OK).body(dogService.insertDog(data));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Dog>> getAllDogs(){
        return ResponseEntity.status(HttpStatus.OK).body(dogService.getAllDogs());
    }


}
