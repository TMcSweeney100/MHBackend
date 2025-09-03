package com.maynoothmh.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.maynoothmh.backend.model.NoteAI;

public interface NotesAiRepository extends MongoRepository<NoteAI, String> {
    List<NoteAI> findByUserIdString(String userIdString);
}
