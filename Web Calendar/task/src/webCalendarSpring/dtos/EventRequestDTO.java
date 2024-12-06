package webCalendarSpring.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import webCalendarSpring.domain.Event;

import java.time.LocalDate;

public record EventRequestDTO(
        @NotNull String event,
        @NotNull @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}") String date
) {
    public Event toEvent() {
        LocalDate date = LocalDate.parse(this.date);
        return new Event(event, date);
    }
}
