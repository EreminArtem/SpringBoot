package ru.eremin.springboot.lessons.endpoint;

import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.eremin.springboot.lessons.entity.Note;
import ru.eremin.springboot.lessons.repository.CategoryRepository;
import ru.eremin.springboot.lessons.repository.NoteRepository;
import ru.eremin.springboot.lessons.soap.note.*;

import java.util.List;
import java.util.UUID;

/**
 * @autor Eremin Artem on 23.01.2019.
 */

@Endpoint
public class NoteEndpoint {

    public static final String LOCATION_URI = "/soap/note";
    public static final String PORT_TYPE_NAME = "NoteEndpointPort";
    public static final String NAMESPACE = "http://eremin.ru/springboot/lessons/soap/note";

    @Autowired
    @Qualifier(NoteRepository.NAME)
    private NoteRepository repository;

    @Autowired
    @Qualifier(CategoryRepository.NAME)
    private CategoryRepository categoryRepository;

    @PayloadRoot(localPart = "createRequest", namespace = NAMESPACE)
    public void create(@RequestPayload final CreateRequest request) {
        final Note note = new Note(
                request.getData(),
                request.getDescription(),
                categoryRepository.findCategoryByName(request.getCategoryName()));
        repository.save(note);
    }


    @ResponsePayload
    @PayloadRoot(localPart = "findNoteRequest", namespace = NAMESPACE)
    public FindNoteResponse findNote(@RequestPayload final FindNoteRequest request) {
        final Note note = repository.findById(request.getId()).get();
        final FindNoteResponse response = new FindNoteResponse();
        response.setNote(toRecord(note));
        return response;
    }

    @ResponsePayload
    @PayloadRoot(localPart = "findAllRequest", namespace = NAMESPACE)
    public FindAllResponse findAll(@RequestPayload final FindAllRequest request) {
        final FindAllResponse response = new FindAllResponse();
        final List<Note> notes = repository.findNoteByCategoryId(request.getCategoryId());
        for (final Note note : notes) {
            response.getRows().add(toRecord(note));
        }
        return response;
    }

    @Nullable
    public NoteRecord toRecord(@Nullable final Note note) {
        if (note == null) return null;
        final NoteRecord record = new NoteRecord();
        record.setId(note.getId());
        record.setDescription(note.getDescription());
        record.setData(note.getData());
        record.setCategoryId(note.getCategory().getId());
        return record;
    }


}
