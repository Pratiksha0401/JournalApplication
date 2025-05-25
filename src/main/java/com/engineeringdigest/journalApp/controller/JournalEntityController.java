package com.engineeringdigest.journalApp.controller;

import com.engineeringdigest.journalApp.entity.JournalEntity;
import com.engineeringdigest.journalApp.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;


@RestController
@RequestMapping("/journal")
public class JournalEntityController {

    @Autowired
    JournalService journalService;

    @GetMapping
    public List<JournalEntity> getAll(){
        return  new ArrayList<>(journalService.getAllJournalEntry());
    }

    @PostMapping
    public void createJournal(@RequestBody JournalEntity journalEntity){
        journalEntity.setDate(LocalDate.now());
        journalService.saveJournalEntry(journalEntity);
    }

    @GetMapping("/{id}")
    public JournalEntity getJournal(@PathVariable String id){
        JournalEntity journalEntity = journalService.getJournalEntry(new ObjectId(id));
        return journalService.getJournalEntry(new ObjectId(id));
    }

}
