package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeApiResponse {

    private String date_time;

    public TimeApiResponse() {
    }

    public TimeApiResponse(String date_time) {
        this.date_time = date_time;
    }

    public LocalDateTime getLocal_time() {
        if (date_time == null || date_time.isEmpty()) return null;

        // convert to LocalDateTime
        OffsetDateTime odt = OffsetDateTime.parse(date_time, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return odt.toLocalDateTime();
    }
}