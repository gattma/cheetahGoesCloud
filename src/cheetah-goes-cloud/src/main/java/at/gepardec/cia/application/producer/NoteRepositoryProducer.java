package at.gepardec.cia.application.producer;

import at.gepardec.cia.db.repository.NoteRepositoryImpl;
import at.gepardec.cia.db.repository.NoteRepositoryMemory;
import at.gepardec.cia.ports.NoteRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Dependent
public class NoteRepositoryProducer {

    @Inject
    @ConfigProperty(name = "cheetah.db.mock")
    Boolean mockEnabled;

    @Inject
    NoteRepositoryMemory noteRepositoryMemory;

    @Inject
    NoteRepositoryImpl noteRepository;

    @Produces
    @NoteRepositoryQualifier
    public NoteRepository produceNoteRepository() {
        if(mockEnabled) {
            return noteRepositoryMemory;
        }

        return noteRepository;
    }
}
