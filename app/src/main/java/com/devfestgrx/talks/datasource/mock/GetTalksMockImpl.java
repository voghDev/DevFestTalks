package com.devfestgrx.talks.datasource.mock;

import com.devfestgrx.talks.global.model.Talk;
import com.devfestgrx.talks.usecase.GetTalks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olmo on 17/11/16.
 */
public class GetTalksMockImpl implements GetTalks {
    @Override
    public void getTalks(Listener listener) {
        List<Talk> list = new ArrayList<Talk>();

        list.add(createMockTalk("9:00", "GDG DevFest Granada 2016 Opening & Keynote", "Salón de actos", "Keynote"));
        list.add(createMockTalk("9:30", "Wearables - Más allá de los smartwatches", "Salón de actos", "Keynote"));
        list.add(createMockTalk("10:30", "Coffee Break", "Salón de actos", "Coffee!"));

        listener.onTalksCompleted(list);
    }

    private Talk createMockTalk(String time, String title, String place, String description) {
        Talk t = new Talk();
        t.setTime(time);
        t.setTitle(title);
        t.setPlace(place);
        t.setText(description);
        return t;
    }
}
