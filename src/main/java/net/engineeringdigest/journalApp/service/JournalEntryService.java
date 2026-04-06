package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntity;
import net.engineeringdigest.journalApp.entity.UserEntity;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {

    @Autowired
    public JournalEntryRepository journalEntryRepository;

    @Autowired
    public UserRepository userRepository;


    public List<JournalEntity> getEntries () {
        return journalEntryRepository.findAll();
    }



    public void createEntry (JournalEntity data , String user_name) {

        UserEntity user = userRepository.findByUserName(user_name)
                .orElseThrow(() -> new RuntimeException("User not found"));

       JournalEntity jl = journalEntryRepository.save(data);
       user.getJournalEntities().add(jl);
       userRepository.save(user);
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
