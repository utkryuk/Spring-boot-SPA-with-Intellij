package com.utkarsh.repository;

import com.utkarsh.model.Phonebook;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonebookRepository extends MongoRepository<Phonebook, String> {
}
