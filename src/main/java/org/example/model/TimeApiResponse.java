package org.example.model;

import com.google.gson.annotations.SerializedName;
import java.time.OffsetDateTime;

public class TimeApiResponse {

    @SerializedName("date_time") // Gson uses this, not @JsonProperty
    private String dateTime;

    public OffsetDateTime getOffsetTime() {
        if (dateTime == null || dateTime.isEmpty()) return null;
        return OffsetDateTime.parse(dateTime);
    }

    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }
}