package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class TimeApiResponse {
    private String date_time;


    public TimeApiResponse(String date_time) {
        this.date_time = date_time;
    }

    public String getLocal_time() {
        return date_time;
    }

    public void setLocal_time(String date_time) {
        this.date_time = date_time;
    }
}
