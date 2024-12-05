package webCalendarSpring;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Event {
    @NotBlank
    private String event;

    @NotNull
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
    private String date;

    public Event() {

    }

    public String getEvent() {
        return event;
    }

    public String getDate() {
        return date;
    }


}
