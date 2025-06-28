package com.demo.journalApp.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "config_journal_app")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ConfigJournalAppEntity {
    private String key;
    private String value;
}
