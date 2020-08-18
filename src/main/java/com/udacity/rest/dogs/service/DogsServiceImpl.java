package com.udacity.rest.dogs.service;

import com.udacity.rest.dogs.entity.Dog;
import com.udacity.rest.dogs.repository.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class DogsServiceImpl implements DogsService{
    @Autowired
    private DogsRepository dogsRepository;

    public List<String> retrieveDogBreed(){
            List<String> breeds = new ArrayList<>();
            List<Dog> dogList = (List<Dog>) dogsRepository.findAll();
             dogList.forEach((dog) ->  breeds.add(dog.getBreed()));
        return breeds;
    }

    public String retrieveDogBreedById(Long id){
        Dog dog = dogsRepository.findDogById(id);
        if(dog == null){
            return  "";
        }
        return dog.getBreed();
    }

    public List<String> retrieveDogNames(){
        List<String> names = new ArrayList<>();
        List<Dog> dogList = (List<Dog>) dogsRepository.findAll();
        dogList.forEach((dog) ->  names.add(dog.getName()));
        return names;
    }



}
