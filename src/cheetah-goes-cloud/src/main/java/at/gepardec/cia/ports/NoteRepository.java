package at.gepardec.cia.ports;

import at.gepardec.cia.domain.model.Note;

import java.util.List;

public interface NoteRepository {

    Note createNote(String note);

    List<Note> getAllNodes();

    boolean deleteNote(Long id);
}
