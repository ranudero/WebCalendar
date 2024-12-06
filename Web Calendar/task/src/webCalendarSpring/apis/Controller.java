package webCalendarSpring.apis;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import webCalendarSpring.dtos.EventRequestDTO;
import webCalendarSpring.dtos.EventResponseDTO;
import webCalendarSpring.dtos.EventDTO;
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

    @GetMapping("/event/{start}/{end}")
    public ResponseEntity<List<EventDTO>> getEventsByDate(@PathVariable("start") String start, @PathVariable("end") String end) {
        List<EventDTO> response = eventH2Service.getEventsByDate(start, end);
        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/event/today")
    public ResponseEntity<List<EventDTO>> getTodayEvents() {
        List<EventDTO> response = eventH2Service.getTodayEvents();
        return ResponseEntity.ok(response);
    }

//    @GetMapping("event")
//    public ResponseEntity<List<EventDTO>> getEvents() {
//        List<EventDTO> response = eventH2Service.getAllEvents();
//        if (response.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("event")
//    public ResponseEntity<List<EventDTO>> getEventsBetween(
//        @RequestParam("start_time") String start,
//        @RequestParam("end_time") String end) {
//        List<EventDTO> response = eventH2Service.getEventsByDate(start, end);
//        if (response.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(response);
//    }

    @GetMapping("/event")
    public ResponseEntity<List<EventDTO>> getEvents(
            @RequestParam(value = "start_time", required = false) String start,
            @RequestParam(value = "end_time", required = false) String end) {
        List<EventDTO> response;
        if (start == null || end == null) {
            response = eventH2Service.getAllEvents();
        } else {
            response = eventH2Service.getEventsByDate(start, end);
        }
        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(response);
    }



    @GetMapping("/event/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable("id") Long id) {
        EventDTO response = eventH2Service.getEventById(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/event/{id}")
    public ResponseEntity<Object> deleteEventById(@PathVariable("id") Long id) {
        EventDTO response = eventH2Service.getEventById(id);
        eventH2Service.deleteEventById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/event")
    public ResponseEntity<EventResponseDTO> addEvent(@RequestBody @Valid EventRequestDTO eventRequestDTO, BindingResult result) {

        EventResponseDTO response = eventH2Service.createNewEvent(eventRequestDTO);
        return ResponseEntity.ok(response);

    }

}
