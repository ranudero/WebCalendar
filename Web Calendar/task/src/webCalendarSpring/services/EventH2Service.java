package webCalendarSpring.services;

import org.springframework.stereotype.Service;
import webCalendarSpring.domain.Event;
import webCalendarSpring.dtos.EventRequestDTO;
import webCalendarSpring.dtos.EventResponseDTO;
import webCalendarSpring.dtos.EventsListDTO;
import webCalendarSpring.repositories.EventRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventH2Service {
    private final EventRepository eventRepository;

    public EventH2Service(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventResponseDTO createNewEvent(EventRequestDTO eventRequestDTO) {
        Event event = eventRequestDTO.toEvent();
        eventRepository.save(event);
        return EventResponseDTO.from(event);
    }

    public List<EventsListDTO> getTodayEvents() {

        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formattedDate = LocalDate.parse(now.format(formatter));
        return eventRepository.findByDate(formattedDate).stream()
                .map(EventsListDTO::from)
                .collect(Collectors.toList());
    }

    public List<EventsListDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(EventsListDTO::from)
                .collect(Collectors.toList());
    }
}
