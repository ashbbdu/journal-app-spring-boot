package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.entity.JournalEntity;
import net.engineeringdigest.journalApp.entity.UserEntity;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import net.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalControllerV2 {


    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<JournalEntity> getAll () {
        return journalEntryService.getEntries();
    }

    @PostMapping("/create/{user_name}")
    public ResponseEntity<JournalEntity> create (@RequestBody JournalEntity data , @PathVariable String user_name) {
        try {
            journalEntryService.createEntry(data , user_name);
            return new ResponseEntity<>(data , HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e );
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalEntity> getById (@PathVariable String id) {
       Optional<JournalEntity> journalEntity =  journalEntryService.getEntryById(id);
       if (journalEntity.isPresent()) {
           return new ResponseEntity<>(journalEntity.get() , HttpStatus.OK);
       }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public boolean deleteById (@PathVariable String id) {
        return journalEntryService.deleteEntryById(id);
    }

    @PutMapping("/{id}")
    public JournalEntity update (@PathVariable String id , @RequestBody JournalEntity data) {
        JournalEntity journalEntity = journalEntryService.getEntryById(id).orElse(null);
        if(journalEntity != null) {
            data.setTitle(data.getTitle() != null && !data.getTitle().isEmpty() ? data.getTitle() : journalEntity.getTitle());
            data.setContent(data.getContent() != null && !data.getContent().isEmpty() ? data.getContent() : journalEntity.getContent());
        } else {
            System.out.println("Entity is null");
        }
        return journalEntryService.update(journalEntity);

    }


}
