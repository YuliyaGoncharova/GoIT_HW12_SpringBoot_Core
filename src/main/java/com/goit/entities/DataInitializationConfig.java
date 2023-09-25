package com.goit.entities;

import com.goit.services.NoteService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializationConfig {

    @Bean
    public ApplicationRunner dataInitializer (NoteService noteService) {
        return args -> {
            noteService.add(new Note(1L, "my 1st note", "addded some info for 1st note"));
            noteService.add(new Note(1L, "my 2nd note", "addded some info for 2nd note"));
            noteService.add(new Note(1L, "my 3rd note", "addded some info for 3rd note"));
        };
    }
}
