package edu.dosw.tallerAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.dosw.tallerAPI.model.entity.Chef;

public interface ChefRepository extends MongoRepository<Chef, String> {
    List<Chef> findByType(String type);
    
}
