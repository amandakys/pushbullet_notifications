package com.example.notifications;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Created by andikoh on 13/08/2017.
 */
public class User {

    private String username;
    private String accessToken;
    private final String creationTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    private int numOfNotificationsPushed = 0;

    public String getUsername() {
        return username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public int getNumOfNotificationsPushed() {
        return numOfNotificationsPushed;
    }

    public void incrementNumOfNotificationsPushed() {
        this.numOfNotificationsPushed++;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
