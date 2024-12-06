package webCalendarSpring.services;

import org.springframework.stereotype.Service;
import webCalendarSpring.NoEventFoundException;
import webCalendarSpring.domain.Event;
import webCalendarSpring.dtos.EventRequestDTO;
import webCalendarSpring.dtos.EventResponseDTO;
import webCalendarSpring.dtos.EventDTO;
import webCalendarSpring.repositories.EventRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public List<EventDTO> getTodayEvents() {

        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formattedDate = LocalDate.parse(now.format(formatter));
        return eventRepository.findByDate(formattedDate).stream()
                .map(EventDTO::from)
                .collect(Collectors.toList());
    }

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(EventDTO::from)
                .collect(Collectors.toList());
    }

    public EventDTO getEventById(Long id) {
        return eventRepository.findById(id)
                .map(EventDTO::from)
                .orElseThrow(NoEventFoundException::new);
    }

    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }

    public List<EventDTO> getEventsByDate(String start, String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return eventRepository.findByDateBetween(startDate, endDate).stream()
                .map(EventDTO::from)
                .collect(Collectors.toList());
    }
}
