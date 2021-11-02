package de.thb.justnoteit.controller.web;

import de.thb.justnoteit.controller.web.form.NotebookFormModel;
import de.thb.justnoteit.entity.Notebook;
import de.thb.justnoteit.service.DeskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class NotebookController {
    private final DeskService deskService;

    /*
     * public String in Java Spring returns String in case of an HTML-Template
     * Example: localhost:8080/notebooks
     */
    @GetMapping("notebooks")
    public String showNotebooks(Model model) {
        List<Notebook> notebookList = deskService.getAllNotebooks();
        model.addAttribute("notebooks", notebookList);
        return "notebooks";
    }

    /*
    http://localhost:8080/notebooks/42
     */
    @GetMapping("notebooks/{id}")
    public String showNotebookDetails(@PathVariable("id") Long id, Model model) {
        Notebook notebook = deskService.getNotebookById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("notebook", notebook);
        return "details";
    }

    /*
    Brauchen wir für WebBaKi Registrierung
     */
    @PostMapping("notebooks")
    public String addNotebook(@Valid NotebookFormModel form, BindingResult result){
        deskService.addNotebook(form.getTitle(), form.getDescription());
        return "redirect:/notebooks";
    }


}
