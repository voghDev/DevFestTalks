package com.devfestgrx.talks.global.model;

import org.parceler.Parcel;

/**
 * Created by olmo on 17/11/16.
 */

@Parcel
public class Talk {
    String title;
    String place;
    String text;
    String imageUrl;
    Speaker speaker;
    String time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public boolean hasImage() {
        return imageUrl != null && imageUrl.length() > 0;
    }
}
