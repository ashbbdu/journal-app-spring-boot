package net.engineeringdigest.journalApp.entity;

// this is pojo

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "journal_entries")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
//@Builder
@Data
public class JournalEntity {
    @Id
    private String id;

    private String title;
    private String content;


}
