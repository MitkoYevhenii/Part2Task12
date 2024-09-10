package ua.goit.emtity.planet;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "planet")
@Entity
@Data
public class Planet {
    private String id;
    private String name;
}
