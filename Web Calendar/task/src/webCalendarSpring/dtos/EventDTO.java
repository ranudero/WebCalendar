package webCalendarSpring.dtos;

import webCalendarSpring.domain.Event;

public record EventDTO(Long id, String event, String date) {

    public static EventDTO from(Event event) {
        String stringDate = String.valueOf(event.getDate());
        return new EventDTO(event.getId(),event.getEvent(), stringDate);
    }
}