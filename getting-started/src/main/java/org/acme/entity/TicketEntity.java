package org.acme.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class TicketEntity extends PanacheEntity {
    private String text;
    private LocalDateTime date;

    // Constructeur
    public TicketEntity() {}

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TicketEntity(String text, LocalDateTime date) {
        this.text = text;
        this.date = date;
    }
}