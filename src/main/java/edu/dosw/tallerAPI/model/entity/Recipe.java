package edu.dosw.tallerAPI.model.entity;
import java.util.List;

import edu.dosw.tallerAPI.model.entity.enums.ChefType;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Document(collection = "receipes")
@Data
@Builder
public class Recipe {

    @Id
    private String id;
    private String title;
    private List<String> ingredients;
    private List<String> steps;
    private Chef chef;
    private int season;
    
}
