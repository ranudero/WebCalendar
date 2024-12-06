package webCalendarSpring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webCalendarSpring.domain.Event;
import webCalendarSpring.dtos.EventRequestDTO;
import webCalendarSpring.dtos.EventResponseDTO;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventService eventService;

    public EventResponseDTO createNewEvent(EventRequestDTO eventRequestDTO) {
        Event event = eventRequestDTO.toEvent();
        return EventResponseDTO.from(event);
    }
}
