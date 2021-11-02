package de.thb.justnoteit.controller.api;

import de.thb.justnoteit.controller.api.model.NotebookVO;
import de.thb.justnoteit.entity.Notebook;
import de.thb.justnoteit.service.DeskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class ApiController {
    private final DeskService deskService;

    @GetMapping("notebooks")
    public List<NotebookVO> getAllNotebooks(){
        List<Notebook> notebooks = deskService.getAllNotebooks();

        return notebooks.stream()
                .map(ApiController::map)
                .collect(Collectors.toList());
    }

    @PostMapping("notebooks")
    public ResponseEntity addNotebook(@RequestBody NotebookVO notebook){
        deskService.addNotebook(notebook.getTitle(), notebook.getDescription());

        return new ResponseEntity(HttpStatus.CREATED);
    }

    public static NotebookVO map(Notebook notebook){
        return NotebookVO.builder()
                .id(notebook.getId())
                .title(notebook.getTitle())
                .description(notebook.getDescription())
                .build();
    }

}
