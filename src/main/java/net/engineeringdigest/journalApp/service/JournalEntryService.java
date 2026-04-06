package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntity;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {

    @Autowired
    public JournalEntryRepository journalEntryRepository;


    public List<JournalEntity> getEntries () {
        return journalEntryRepository.findAll();
    }

    public void createEntry (JournalEntity data) {
        journalEntryRepository.save(data);
    }

    public Optional<JournalEntity> getEntryById (String id) {
        return journalEntryRepository.findById(id);
    }

    public boolean deleteEntryById (String id) {
        journalEntryRepository.deleteById(id);
        return true;
    }

    public JournalEntity update (JournalEntity data) {
//        Optional<JournalEntity> myEntry = journalEntryRepository.findById(id);
//        if(myEntry != null) {
//            myEntry.setContent
//        }
       return journalEntryRepository.save(data);
    }

}
