package com.goit.services;

import com.goit.entities.Note;

import java.util.List;
public interface NoteServiceInt {
    List<Note> listAll();
    Note add(Note note);
    void deleteById(long id);
    void update(Note note);
    Note getById(long id);

}
