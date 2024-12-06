package webCalendarSpring.apis;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import webCalendarSpring.dtos.EventRequestDTO;
import webCalendarSpring.dtos.EventResponseDTO;
import webCalendarSpring.services.EventService;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping
public class Controller {

    private final EventService eventService;


    @GetMapping("/event/today")
    public ResponseEntity<String> getTodayEvents() {
        return ResponseEntity.ok("[]");
    }

    @PostMapping("/event")
    public ResponseEntity<EventResponseDTO> addEvent(@RequestBody @Valid EventRequestDTO eventRequestDTO, BindingResult result) {

         EventResponseDTO response = eventService.createNewEvent(eventRequestDTO);
        return ResponseEntity.ok(response);

    }

}
