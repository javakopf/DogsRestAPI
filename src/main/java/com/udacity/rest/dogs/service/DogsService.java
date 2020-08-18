package com.udacity.rest.dogs.service;

import java.util.List;

public interface DogsService {

    public List<String> retrieveDogBreed();

    public String retrieveDogBreedById(Long id);

    public List<String> retrieveDogNames();
}
