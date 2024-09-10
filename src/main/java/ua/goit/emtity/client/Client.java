package ua.goit.emtity.client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "client")
@Entity
@Data
public class Client {
    @Id
    private long id;
    @Column
    private String name;
}
