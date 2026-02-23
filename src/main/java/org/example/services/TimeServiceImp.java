package org.example.services;

import kong.unirest.Unirest;
import org.example.config.TimeApiConfig;
import org.example.model.TimeApiResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Service
@Primary
public class TimeServiceImp implements TimeService {

    private final TimeApiConfig timeApiConfig;

    public TimeServiceImp(TimeApiConfig timeApiConfig) {
        this.timeApiConfig = timeApiConfig;
    }

    @Override
    @Cacheable(value = "time_cache", key = "#ipAddress")
    public OffsetDateTime getCurrentTime(String ipAddress) {
        TimeApiResponse response = Unirest.get(timeApiConfig.getEndpoint() + ipAddress)
                .asObject(TimeApiResponse.class)
                .getBody();
        if (response != null && response.getOffsetTime() != null) {
            //converts to local time when inserting to db
            return response.getOffsetTime();
        } else {
            return OffsetDateTime.now();
        }
    }

}
