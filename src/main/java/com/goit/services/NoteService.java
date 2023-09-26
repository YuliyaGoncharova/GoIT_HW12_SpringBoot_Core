package com.goit.services;


import com.goit.entities.Note;
import com.goit.repositories.NoteRepository;
import org.springframework.stereotype.Service;

//import java.util.*;

import java.util.List;
import java.util.Random;

@Service
public class NoteService implements NoteServiceInt {

    private final NoteRepository  noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }



    /* List<Note> listAll() - повертає список всіх нотаток */
    @Override
    public List<Note> listAll() {
        return noteRepository.findAll();
            }

    /* Note add(Note note) - додає нову нотатку, генеруючи для цієї нотатки унікальний (випадковий)
        числовий ідентифікатор, повертає цю ж нотатку з
        згенерованим ідентифікатором. */
    @Override
    public Note add(Note note) {
        return noteRepository.save(note);
    }

    /* void deleteById(long id) - видаляє нотатку з вказаним ідентифікатором.
        Якщо нотатки з ідентифікатором немає - викидає виключення. */

    @Override
    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    /*  void update(Note note) -   шукає нотатку по note.id. Якщо нотатка є - оновлює для неї title та content.
            Якщо нотатки немає - викидає виключення.
     */
    @Override
    public void update(Note note) {
        noteRepository.save(note);
    }

    /*  Note getById(long id) - - повертає нотатку по її ідентифікатору.
        Якщо нотатки немає - викидає виключення.
     */
    @Override
    public Note getById(long id) {

        return noteRepository.findById(id).orElse(null);
    }

}
