package ua.goit.entity.ticket;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class Ticket {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String createAt;

    private long clientId;
    private String fromPlanetId;
    private String toPlanetId;
}
