package ua.goit.emtity.ticket;

import lombok.Data;

@Data
public class Ticket {
    private long id;
    private String createAt;

    private long clientId;
    private String fromPlanetId;
    private String toPlanetId;
}
