package com.example.demo.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Travel;

//...
@Repository
public interface TravelRepository extends CrudRepository<Travel, Long>{
 // this method retrieves all the books from the database
 List<Travel> findAll();
 // this method finds books with descriptions containing the search string
 List<Travel> findByDescriptionContaining(String search);
 // this method counts how many titles contain a certain string
 Long countByNameContaining(String search);
// // this method deletes a book that starts with a specific title
 Long deleteByNameStartingWith(String search);
}

