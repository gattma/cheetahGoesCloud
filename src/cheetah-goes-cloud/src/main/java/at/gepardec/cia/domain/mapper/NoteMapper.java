package at.gepardec.cia.domain.mapper;

import at.gepardec.cia.adapters.db.entity.NoteEntity;
import at.gepardec.cia.domain.model.Note;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class NoteMapper {

    public List<Note> mapAllNoteEntitiesToDto(List<NoteEntity> notes) {
        if (notes == null || notes.isEmpty()) {
            return Collections.emptyList();
        }

        return notes.stream()
                .map(this::mapNoteEntityToDto)
                .collect(Collectors.toList());
    }

    public Note mapNoteEntityToDto(NoteEntity note) {
        if (note == null) {
            return null;
        }
        return new Note(note.getId(), note.getNote(), note.getCreationDate());
    }
}
