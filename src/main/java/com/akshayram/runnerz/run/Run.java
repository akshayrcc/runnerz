package com.akshayram.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        @NotEmpty
        String status,
        LocalDateTime startedOn,
        @Positive
        Integer miles,
        LocalDateTime completedOn,
        Location location
) {

    // validations
    public Run {
        if (!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed date cannot be before started date");
        }

        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
    }
}
