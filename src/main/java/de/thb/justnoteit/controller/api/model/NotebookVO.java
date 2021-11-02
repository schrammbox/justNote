package de.thb.justnoteit.controller.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotebookVO {
    private long id;
    private String title;
    private String description;
}
