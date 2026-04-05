package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.entity.JournalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalController {

    private Map<Long , JournalEntity> journalEntries = new HashMap<>();

    @GetMapping("/list")
    public List<JournalEntity> getAll () {
        List <JournalEntity> list = new ArrayList<>(journalEntries.values());

        return list;
    }

    @PostMapping("/create")
    public void create (@RequestBody JournalEntity data) {
//        JournalEntity j = new JournalEntity();
//        j.setContent("ashish");;
//        j.setId(1212);
//        j.setTitle("fist");
        journalEntries.put(data.getId() , data);

    }

    @GetMapping("/{id}")
    public JournalEntity getById (@PathVariable Long id) {
       return journalEntries.get(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById (@PathVariable Long id) {
        journalEntries.remove(id);
        return true;
    }

    @PutMapping("/{id}")
    public JournalEntity update (@RequestBody JournalEntity data) {
        return journalEntries.put(data.getId() , data);
    }

}
