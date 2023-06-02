package at.gepardec.cia.service;

import at.gepardec.cia.application.producer.NoteRepositoryQualifier;
import at.gepardec.cia.domain.model.Note;
import at.gepardec.cia.ports.NoteRepository;
import at.gepardec.cia.ports.NoteService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class NoteServiceImpl implements NoteService {

    @Inject
    @NoteRepositoryQualifier
    NoteRepository repository;

    @Override
    public Note createNote(String note) {
        return repository.createNote(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return repository.getAllNodes();
    }

    @Override
    public boolean deleteNote(Long id) {
        return repository.deleteNote(id);
    }
}
