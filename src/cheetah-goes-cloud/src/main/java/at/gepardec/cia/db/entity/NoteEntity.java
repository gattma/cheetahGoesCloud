package at.gepardec.cia.db.entity;

import java.time.LocalDateTime;

public class NoteEntity {

    Long id;
    String note;
    LocalDateTime creationDate;

    public NoteEntity(Long id, String note) {
        this.id = id;
        this.note = note;
        this.creationDate = LocalDateTime.now();
    }

    public String getNote() {
        return note;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Long getId() {
        return id;
    }
}
