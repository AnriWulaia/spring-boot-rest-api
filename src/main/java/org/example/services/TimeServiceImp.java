package org.example.services;

import kong.unirest.Unirest;
import org.example.config.TimeApiConfig;
import org.example.model.TimeApiResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Primary
public class TimeServiceImp implements TimeService {

    private final TimeApiConfig timeApiConfig;

    public TimeServiceImp(TimeApiConfig timeApiConfig) {
        this.timeApiConfig = timeApiConfig;
    }

    @Override
    public LocalDateTime getCurrentTime(String ipAddress) {
        TimeApiResponse response = Unirest.get(timeApiConfig.getEndpoint() + ipAddress)
                .asObject(TimeApiResponse.class).getBody();
        if (response != null) {
            return response.getLocal_time();
        } else {
            return LocalDateTime.now();
        }
    }

}
