package at.gepardec.cia.adapters.db.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class NoteEntity {

    @Id
    @GeneratedValue(generator = "noteIdGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "noteIdGenerator", sequenceName = "sequence_note_id", allocationSize = 1)
    Long id;
    String note;
    LocalDateTime creationDate;

    public NoteEntity() {
    }

    public NoteEntity(Long id, String note) {
        this.id = id;
        this.note = note;
        this.creationDate = LocalDateTime.now();
    }

    public NoteEntity(String note) {
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
