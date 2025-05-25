package com.engineeringdigest.journalApp.controller;

import com.engineeringdigest.journalApp.entity.JournalEntity;
import com.engineeringdigest.journalApp.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        journalService.saveJournalEntry(journalEntity);
    }

}
