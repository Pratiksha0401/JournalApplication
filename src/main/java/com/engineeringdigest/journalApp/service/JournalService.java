package com.engineeringdigest.journalApp.service;


import com.engineeringdigest.journalApp.entity.JournalEntity;
import com.engineeringdigest.journalApp.repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    public void saveJournalEntry(JournalEntity journalEntity){
         journalRepository.save(journalEntity);
    }

    public JournalEntity getJournalEntry(ObjectId id){
        return journalRepository.findById(id).get();
    }

    public List<JournalEntity> getAllJournalEntry(){
        return journalRepository.findAll();
    }
}
