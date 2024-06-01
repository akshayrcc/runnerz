package com.akshayram.runnerz.run;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        String title,
        String status,
        LocalDateTime startedOn,
        Integer miles,
        LocalDateTime completedOn,
        Location location
) {


}
