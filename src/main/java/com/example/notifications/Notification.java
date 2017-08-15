package com.example.notifications;

/**
 * Created by andikoh on 15/08/2017.
 */
public class Notification {
    private String type = "note";
    private String body = "You have a new notification";
    private String title = "Notification";

    public String getType() {
        return type;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
