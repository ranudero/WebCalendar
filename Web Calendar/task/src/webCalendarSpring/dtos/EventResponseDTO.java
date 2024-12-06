package webCalendarSpring.dtos;

import webCalendarSpring.domain.Event;

public record EventResponseDTO(String message, String event, String date) {

    public static EventResponseDTO from(Event event) {
        String stringDate = String.valueOf(event.getDate());
        return new EventResponseDTO("The event has been added!", event.getEvent(), stringDate);
    }
}
