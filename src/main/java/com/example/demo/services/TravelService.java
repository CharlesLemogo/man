package com.example.demo.services;

import java.util.List;
import java.util.Optional;


//...
import org.springframework.stereotype.Service;

import com.example.demo.models.Travel;
import com.example.demo.repositories.TravelRepository;
@Service
public class TravelService {
 // adding the burger repository as a dependency
 private final TravelRepository travelRepository;
 
 public TravelService(TravelRepository travelRepository) {
     this.travelRepository = travelRepository;
 }
 public List<Travel> allTravels() {
     return travelRepository.findAll();
 }
 public Travel addTravel(Travel b) {
     return travelRepository.save(b);
 }
 
 public Travel findTravel(Long id) {
     Optional<Travel> optionalTravel = travelRepository.findById(id);
     if(optionalTravel.isPresent()) {
         return optionalTravel.get();
     } else {
         return null;
     }
 }
 public Travel updateTravel(Travel travel) {
	    Optional<Travel> optionalTravel = travelRepository.findById(travel.getId());
	    if (optionalTravel.isPresent()) {
	        Travel existingTravel = optionalTravel.get();
	        existingTravel.setName(travel.getName());
	        existingTravel.setVendor(travel.getVendor());
	        existingTravel.setDescription(travel.getDescription());
	        existingTravel.setAmount(travel.getAmount());
	        return travelRepository.save(existingTravel);
	    } else {
	        throw new IllegalArgumentException("Travel not found with ID: " + travel.getId());
	    }
	}
 
 public void deleteTravel(Long id) {
	    travelRepository.deleteById(id);
	}

}