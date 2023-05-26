package at.gepardec.cia.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Note {

    @JsonProperty
    Long id;

    @JsonProperty
    String note;

    @JsonProperty
    LocalDateTime creationDate;

    public Note(Long id, String note, LocalDateTime creationDate) {
        this.id = id;
        this.note = note;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
