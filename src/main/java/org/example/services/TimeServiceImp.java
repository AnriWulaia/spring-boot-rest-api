package org.example.services;

import kong.unirest.Unirest;
import org.example.config.TimeApiConfig;
import org.example.model.TimeApiResponse;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImp implements TimeService {

    private final TimeApiConfig timeApiConfig;

    public TimeServiceImp(TimeApiConfig timeApiConfig) {
        this.timeApiConfig = timeApiConfig;
    }

    @Override
    public String getCurrentTime(String city) {
        TimeApiResponse response = Unirest.get(timeApiConfig.getEndpoint() + timeApiConfig.getContinent() + "%2F" + city)
                .asObject(TimeApiResponse.class).getBody();
        return response.getLocal_time();
    }

}
