package com.maynoothmh.backend.controller;

import com.maynoothmh.backend.model.NoteAI;
import com.maynoothmh.backend.repository.NotesAiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notesAI")
public class NotesAIController {

    @Autowired
    private NotesAiRepository notesRepo;

    // 🔹 Save a new note
    @PostMapping
    public ResponseEntity<NoteAI> saveNote(@RequestBody NoteAI note) {
        NoteAI savedNote = notesRepo.save(note);
        return ResponseEntity.ok(savedNote);
    }

    // 🔹 Get all notes for a user
    @GetMapping("/{userId}")
    public ResponseEntity<List<NoteAI>> getUserNotes(@PathVariable String userId) {
        List<NoteAI> notes = notesRepo.findByUserIdString(userId);
        return ResponseEntity.ok(notes);
    }
}
