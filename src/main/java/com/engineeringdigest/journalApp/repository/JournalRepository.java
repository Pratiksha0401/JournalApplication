package com.engineeringdigest.journalApp.repository;

import com.engineeringdigest.journalApp.entity.JournalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends MongoRepository<JournalEntity, String> {
}
