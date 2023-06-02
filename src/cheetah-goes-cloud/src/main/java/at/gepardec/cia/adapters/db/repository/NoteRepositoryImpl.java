package at.gepardec.cia.adapters.db.repository;

import at.gepardec.cia.adapters.db.entity.NoteEntity;
import at.gepardec.cia.domain.mapper.NoteMapper;
import at.gepardec.cia.domain.model.Note;;
import at.gepardec.cia.domain.ports.NoteRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class NoteRepositoryImpl implements NoteRepository, PanacheRepository<NoteEntity> {

    @Inject
    NoteMapper mapper;

    @Override
    @Transactional
    public Note createNote(String note) {
        var entity = new NoteEntity(note);
        persist(entity);
        return mapper.mapNoteEntityToDto(entity);
    }

    @Override
    public List<Note> getAllNodes() {
        return mapper.mapAllNoteEntitiesToDto(listAll());
    }

    @Override
    @Transactional
    public boolean deleteNote(Long id) {
        return deleteById(id);
    }
}
