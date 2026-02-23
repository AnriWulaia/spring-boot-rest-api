package org.example.services;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public interface TimeService {
    OffsetDateTime getCurrentTime(String ipAddress);
}
