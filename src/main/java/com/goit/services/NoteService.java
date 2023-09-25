package com.goit.services;


import com.goit.entities.Note;
import org.springframework.stereotype.Service;

//import java.util.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class NoteService implements NoteServiceInt {

    private final Map<Long, Note> notes = new HashMap<>();

    /* List<Note> listAll() - повертає список всіх нотаток */
    @Override
    public List<Note> listAll() {
        return List.copyOf(notes.values());
    }

    /* Note add(Note note) - додає нову нотатку, генеруючи для цієї нотатки унікальний (випадковий)
        числовий ідентифікатор, повертає цю ж нотатку з
        згенерованим ідентифікатором. */
    @Override
    public Note add(Note note) {
        long id = new Random().nextLong();
        note.setId(id);
        notes.put(id,note);
        return note;
    }

    /* void deleteById(long id) - видаляє нотатку з вказаним ідентифікатором.
        Якщо нотатки з ідентифікатором немає - викидає виключення. */

    @Override
    public void deleteById(long id) {
        if (notes.containsKey(id)){
            notes.remove(id);
        } else {
            throw new NullPointerException("Note with ID " + id + "can't be deleted because it doesn't exist");
        }
    }

    /*  void update(Note note) -   шукає нотатку по note.id. Якщо нотатка є - оновлює для неї title та content.
            Якщо нотатки немає - викидає виключення.
     */
    @Override
    public void update(Note note) {
        if (notes.containsKey(note.getId())) {
            notes.put(note.getId(),note);
        } else {
            throw new NullPointerException("Note with ID " + note.getId() + " can't be updated because it doesn't exist");
        }
    }

    /*  Note getById(long id) - - повертає нотатку по її ідентифікатору.
        Якщо нотатки немає - викидає виключення.
     */
    @Override
    public Note getById(long id) {
        if (notes.containsKey(id)){
            Note note = notes.get(id);
            return note;
        } else {
            throw new NullPointerException("Note with id " + id + " can't be gotten because it doesn't exist");
        }
    }

}
