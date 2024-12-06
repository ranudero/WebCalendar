package webCalendarSpring.services;

import webCalendarSpring.dtos.EventRequestDTO;
import webCalendarSpring.dtos.EventResponseDTO;

public interface EventService {
    EventResponseDTO createNewEvent(EventRequestDTO eventRequestDTO);
}
