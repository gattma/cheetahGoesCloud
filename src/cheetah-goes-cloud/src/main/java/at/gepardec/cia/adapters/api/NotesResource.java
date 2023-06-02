package at.gepardec.cia.adapters.api;

import at.gepardec.cia.domain.ports.NoteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/notes")
public class NotesResource {

    @Inject
    NoteService noteService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllNotes() {
        var allNotes = noteService.getAllNotes();
        return Response.ok(allNotes).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNote(String note) {
        var result = noteService.createNote(note);
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteNote(@PathParam("id") Long id) {
        var deleted = noteService.deleteNote(id);
        return Response.ok(deleted).build();
    }

}
