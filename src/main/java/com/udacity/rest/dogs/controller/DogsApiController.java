package com.udacity.rest.dogs.controller;

import com.udacity.rest.dogs.entity.Dog;
import com.udacity.rest.dogs.service.DogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogsApiController {

    @Autowired
    private DogsService dogsService;

    @GetMapping("/listDogBreeds")
    public ResponseEntity<List<String>> listDogBreeds(){
        List<String> list = dogsService.retrieveDogBreed();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getDogBreedsById")
    public ResponseEntity<String> getDogBreedsById(@RequestParam Long id) {
        String breed =  dogsService.retrieveDogBreedById(id);
        if(breed!=null && StringUtils.isEmpty(breed)){
            return new ResponseEntity<>(breed, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(breed, HttpStatus.OK);
    }

    @GetMapping("/listDogNames")
    public ResponseEntity<List<String>>  listNames() {
        List<String> names = dogsService.retrieveDogNames();
        return new ResponseEntity<>(names, HttpStatus.OK);
    }

}
