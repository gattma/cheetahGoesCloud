package at.gepardec.cia.domain.ports;

import at.gepardec.cia.domain.model.Note;

import java.util.List;

public interface NoteService {

    Note createNote(String note);

    List<Note> getAllNotes();

    boolean deleteNote(Long id);

}
