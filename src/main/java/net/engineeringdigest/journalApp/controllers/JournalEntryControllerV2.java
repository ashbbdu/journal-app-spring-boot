package net.engineeringdigest.journalApp.controllers;


import net.engineeringdigest.journalApp.entiity.JournalEntity;
import net.engineeringdigest.journalApp.services.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/journal/v2")
public class JournalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;


    @PostMapping
    public JournalEntity createEntry (@RequestBody JournalEntity journalEntity ) {
        journalEntryService.save(journalEntity);
        return journalEntity;
    }

    @GetMapping
    public List<JournalEntity> getAllEntries () {
        return journalEntryService.getAllEntries();
    }

    @GetMapping(path = "/{id}")
    public JournalEntity getEntryById (@PathVariable ObjectId id) {
        return journalEntryService.getEntryById(id).orElse(null);
    }

    @PutMapping(path = "/update/{id}")
    public JournalEntity update (@PathVariable ObjectId id , @RequestBody JournalEntity data) {
        JournalEntity old =  journalEntryService.getEntryById(id).orElse(null);
        if(old != null) {
            old.setTitle(!Objects.equals(data.getTitle(), "") ? data.getTitle() : old.getTitle());
            old.setContent(!Objects.equals(data.getContent(), "") ? data.getContent() : old.getContent());
        }
        assert old != null;
        journalEntryService.save(old);
        return old;
    }
}
