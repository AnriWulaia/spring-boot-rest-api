package org.example.services;

import java.time.LocalDateTime;

public interface TimeService {
    LocalDateTime getCurrentTime(String ipAddress);
}
