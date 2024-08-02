package com.senacen.Unidle.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer miles,
        Location location
) {

    public Run {
        if (!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("You cannot complete a run before it is started.");
        }
    }
}
