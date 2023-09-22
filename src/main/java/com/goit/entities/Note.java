package com.goit.entities;

import lombok.Data;
import lombok.Builder;

@Data
public class Note {
    private Long id;
    private String title;
    private String content;

}
