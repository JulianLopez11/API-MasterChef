package edu.dosw.tallerAPI.model.entity;

import lombok.Data;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.dosw.tallerAPI.model.entity.enums.ChefType;

@Document(collection = "chefs")
@Data
@Builder
public class Chef {
    @Id
    private String id;
    private String name;
    private ChefType chefType;

}
