package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.entity.JournalEntity;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalControllerV2 {


    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping("/list")
    public List<JournalEntity> getAll () {
        return journalEntryService.getEntries();
    }

    @PostMapping("/create")
    public void create (@RequestBody JournalEntity data) {
        journalEntryService.createEntry(data);
    }

    @GetMapping("/{id}")
    public Optional<JournalEntity> getById (@PathVariable String id) {
        return journalEntryService.getEntryById(id);

    }

    @DeleteMapping("/{id}")
    public boolean deleteById (@PathVariable String id) {
        return journalEntryService.deleteEntryById(id);
    }

    @PutMapping("/{id}")
    public JournalEntity update (@RequestBody JournalEntity data) {
        return null;
    }

}
