package webCalendarSpring.apis;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import webCalendarSpring.dtos.EventRequestDTO;
import webCalendarSpring.dtos.EventResponseDTO;
import webCalendarSpring.dtos.EventsListDTO;
import webCalendarSpring.services.EventH2Service;

import java.util.List;

@RestController
@Validated
@RequestMapping
public class Controller {

    private final EventH2Service eventH2Service;

    public Controller(EventH2Service eventH2Service) {
        this.eventH2Service = eventH2Service;
    }

    @GetMapping("/event/today")
    public ResponseEntity<List<EventsListDTO>> getTodayEvents() {
        List<EventsListDTO> response = eventH2Service.getTodayEvents();
        return ResponseEntity.ok(response);
    }

    @GetMapping("event")
    public ResponseEntity<List<EventsListDTO>> getEvents() {
        List<EventsListDTO> response = eventH2Service.getAllEvents();
        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/event")
    public ResponseEntity<EventResponseDTO> addEvent(@RequestBody @Valid EventRequestDTO eventRequestDTO, BindingResult result) {

        EventResponseDTO response = eventH2Service.createNewEvent(eventRequestDTO);
        return ResponseEntity.ok(response);

    }

}
