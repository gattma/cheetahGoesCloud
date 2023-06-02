package at.gepardec.cia.db.repository;

import at.gepardec.cia.domain.model.Note;
import at.gepardec.cia.ports.NoteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.resteasy.reactive.common.NotImplementedYet;

import java.util.List;

@ApplicationScoped
public class NoteRepositoryImpl implements NoteRepository {
    @Override
    public Note createNote(String note) {
        throw new NotImplementedYet();
    }

    @Override
    public List<Note> getAllNodes() {
        throw new NotImplementedYet();
    }

    @Override
    public boolean deleteNote(Long id) {
        throw new NotImplementedYet();
    }
}
