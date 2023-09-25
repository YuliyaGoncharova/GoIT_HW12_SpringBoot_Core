package com.goit.entities;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Note {
    private Long id;
    private String title;
    private String content;

}
