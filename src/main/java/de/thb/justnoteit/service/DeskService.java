package de.thb.justnoteit.service;

import de.thb.justnoteit.entity.Notebook;
import de.thb.justnoteit.repository.NoteRepository;
import de.thb.justnoteit.repository.NotebookRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Builder
@AllArgsConstructor
public class DeskService {

    private final NotebookRepository notebookRepository;
    private final NoteRepository noteRepository;

    public List<Notebook> getAllNotebooks(){
        return (List<Notebook>) notebookRepository.findAll();
    }

    public Optional <Notebook> getNotebookById(long id){
       return notebookRepository.findById(id);
    }

    public Notebook addNotebook(String title, String description){
        return notebookRepository.save(Notebook.builder()
            .title(title)
            .description(description)
            .build());

    }
}
