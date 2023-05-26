package at.gepardec.cia.db.repository;

import at.gepardec.cia.db.entity.NoteEntity;
import at.gepardec.cia.domain.mapper.NoteMapper;
import at.gepardec.cia.domain.model.Note;
import at.gepardec.cia.ports.NoteRepository;
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
        var newNote = new NoteEntity(id, note);
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
