package com.udacity.rest.dogs.repository;

import com.udacity.rest.dogs.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DogsRepository extends CrudRepository<Dog,Long> {

    @Query("select d from Dog d where d.id =?1")
    Dog findDogById(Long id);

}
