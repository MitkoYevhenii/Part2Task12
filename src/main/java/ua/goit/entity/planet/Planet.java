package ua.goit.entity.planet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "planet")
@Entity
@Data
public class Planet {

    @Id
    @Column(length = 100, nullable = false, name = "id")
    private String id;

    @Column(length = 500, nullable = false, name = "name")
    private String name;
}
