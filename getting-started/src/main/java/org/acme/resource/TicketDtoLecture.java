package org.acme.resource;

import java.time.LocalDateTime;

public class TicketDtoLecture {
    private String text;
    private LocalDateTime date;

    // Constructeur
    public TicketDtoLecture() {}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public TicketDtoLecture(String text) {
        this.text = text;
    }
}