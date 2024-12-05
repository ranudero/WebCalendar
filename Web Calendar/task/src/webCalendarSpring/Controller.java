package webCalendarSpring;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
@RequestMapping
public class Controller {

    public Controller() {

    }

    @GetMapping("/event/today")
    public ResponseEntity<String> getTodayEvents() {
        return ResponseEntity.ok("[]");
    }

    @PostMapping("/event")
    public ResponseEntity<Map<String, Object>> addEvent(@RequestBody @Valid Event event, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.noContent().build();
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "The event has been added!");
            response.put("event", event.getEvent());
            response.put("date", event.getDate());
            return ResponseEntity.ok(response);
        }
    }

}
