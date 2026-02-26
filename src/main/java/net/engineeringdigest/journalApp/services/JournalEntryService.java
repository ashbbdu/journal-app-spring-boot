package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.entiity.JournalEntity;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;


    public void save (JournalEntity journalEntity) {
        journalEntity.setDate(LocalDateTime.now());
        journalEntryRepository.save(journalEntity);
    }

    public List<JournalEntity> getAllEntries () {
       return journalEntryRepository.findAll();
    }

    public Optional<JournalEntity> getEntryById (ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    public JournalEntity updateEntry (ObjectId id , JournalEntity data ) {
        return journalEntryRepository.save(data);
    }

}
