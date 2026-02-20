package org.acme.resource;

public class TicketDto {
    private String text;

    // Constructeur
    public TicketDto() {}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TicketDto(String text) {
        this.text = text;
    }
}