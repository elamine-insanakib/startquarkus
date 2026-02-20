package org.acme.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Ticket extends PanacheEntity {
    public String text;
    public LocalDateTime date;

    // Constructeur
    public Ticket() {}

    public Ticket(String text, LocalDateTime date) {
        this.text = text;
        this.date = date;
    }
}