package de.thb.justnoteit.controller;

import de.thb.justnoteit.entity.Notebook;
import de.thb.justnoteit.service.DeskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class NotebookController {
    private final DeskService deskService;

    @GetMapping("notebooks")
    public String showNotebooks(Model model){
        List<Notebook> notebooks = deskService.getAllNotebooks();
        model.addAttribute(notebooks);
        return "notebooks";
    }
}
