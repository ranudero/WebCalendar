package webCalendarSpring.dtos;

import webCalendarSpring.domain.Event;

public record EventsListDTO(Long id, String event, String date) {

    public static EventsListDTO from(Event event) {
        String stringDate = String.valueOf(event.getDate());
        return new EventsListDTO(event.getId(),event.getEvent(), stringDate);
    }
}