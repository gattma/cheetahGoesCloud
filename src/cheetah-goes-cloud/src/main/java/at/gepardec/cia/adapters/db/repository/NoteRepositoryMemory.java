package at.gepardec.cia.adapters.db.repository;

import at.gepardec.cia.adapters.db.entity.NoteEntity;
import at.gepardec.cia.domain.mapper.NoteMapper;
import at.gepardec.cia.domain.model.Note;
import at.gepardec.cia.domain.ports.NoteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class NoteRepositoryMemory implements NoteRepository {

    private final Map<Long, NoteEntity> notes;

    @Inject
    NoteMapper mapper;

    public NoteRepositoryMemory() {
        this.notes = new HashMap<>();
    }

    @Override
    public Note createNote(String note) {
        var id = nextId();
        var newNote = new NoteEntity(note);
        notes.put(id, newNote);
        return mapper.mapNoteEntityToDto(newNote);
    }

    @Override
    public List<Note> getAllNodes() {
        return mapper.mapAllNoteEntitiesToDto(notes.values().stream().toList());
    }

    @Override
    public boolean deleteNote(Long id) {
        var entry = notes.remove(id);
        return entry != null;
    }

    private Long nextId() {
        return (long) (notes.size() + 1);
    }
}
