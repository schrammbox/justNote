package de.thb.justnoteit.repository;

import de.thb.justnoteit.entity.Note;
import de.thb.justnoteit.entity.Notebook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Note.class, idClass = Long.class)
public interface NoteRepository extends CrudRepository<Note, Long> {

}
