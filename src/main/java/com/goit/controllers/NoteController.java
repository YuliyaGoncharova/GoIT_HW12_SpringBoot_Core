package com.goit.controllers;

import com.goit.entities.Note;
import com.goit.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/note")
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/add")
    public String addNote() {
        return "add_note";
    }

    @PostMapping("/add")
    public String addNoteToList(@ModelAttribute("note") Note createNote){
        noteService.add(createNote);
        return "redirect:/note/list";
    }
    /*
     GET /note/list -
     отримати список нотаток. Виводиться список нотаток (title та content),
     кожну нотатку можна видалити або редагувати
     */

        @GetMapping("/list")
        public String listNotes(Model model) {
            List<Note> notes = noteService.listAll();
            model.addAttribute("notes", notes);
            return "list_all_notes";
        }


    /* POST /note/delete -
       видалити нотатку по ID. Після видалення нотатки відбувається редирект на /note/list
     */

    @PostMapping("/delete")
    public String deleteNote(@RequestParam long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    /* GET /note/edit?id=xxx -
        сторінка редагування нотатку (відкривається по натисненню на кнопку Редагувати на списку нотаток).
     */

    @GetMapping("/edit")
    public String editNoteForm (@RequestParam long id, Model model) {
        Optional<Note> note = noteService.getById(id);
        model.addAttribute("note", note.get());
        return "note_edit";
    }

    @PostMapping("/edit")
    public String editNoteSubmit (@ModelAttribute Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }

    /* POST /note/edit - сюди відправляється запит на редагування нотатки. Після збереження оновленого контенту нотатки відбувається редирект на /note/list
     */


}
