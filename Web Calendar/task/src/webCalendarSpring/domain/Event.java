package webCalendarSpring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;

@Entity

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String event;

    @NotNull
    //@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
    private LocalDate date;

    public Event() {
    }

    public Event(String event, LocalDate date) {
        this.event = event;
        this.date = date;

    }

    public Long getId() {
        return id;
    }

    public @NotBlank String getEvent() {
        return event;
    }

    public @NotNull LocalDate getDate() {
        return date;
    }
}
