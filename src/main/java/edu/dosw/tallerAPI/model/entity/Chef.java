package edu.dosw.tallerAPI.model.entity;
import edu.dosw.tallerAPI.model.entity.enums.ChefType;

import lombok.Data;
import lombok.Builder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chefs")
@Data
@Builder
public class Chef {
    @Id
    private String id;
    private String name;
    private ChefType type;

}
