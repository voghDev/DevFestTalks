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
        list.add(createMockTalk("9:30", "Wearables - Más allá de los smartwatches", "Salón de actos", "Los dispositivos \"vestibles\" están empezando a aparecer en el mercado. Los SmartWatches son los más difundidos y conocidos, y otros como las SmartGlasses van un poco más despacio. Pero que podemos encontrar en el mercado como tecnología \"vestible\". Hablaremos de los proyectos Jaqcuard y Verily en los que Google está involucrado y cual puede ser la opinión del mercado sobre toda esta tecnología."));
        list.add(createMockTalk("10:30", "Coffee Break", "Cafetería", "Coffee!"));
        list.add(createMockTalk("11:00", "Tensorflow: la IA detrás de Google\n", "Aula 1.2", "Coffee!"));
        list.add(createMockTalk("11:00", "¿Cómo trabaja un pro de Android? (O como trabajaría yo si fuera uno)", "Salón de actos", "Coffee!"));
        list.add(createMockTalk("12:00", "Material Design - A Glimpse Into the Future", "Salón de actos", "Coffee!"));
        list.add(createMockTalk("13:00", "Polymer: el fin a tus problemas con el front-end", "Salón de actos", "Coffee!"));
        list.add(createMockTalk("14:00", "Lunch", "Salón de actos", "Comidaaa!"));
        list.add(createMockTalk("16:00", "Building our Fisher-Price Android architecture from scratch", "Aula 1.2", "Coffee!"));
        list.add(createMockTalk("16:00", "Microservices on Google Cloud Platform, the next generation of architectures.", "Salón de actos", "Coffee!"));
        list.add(createMockTalk("17:00", "Firebase", "Salón de actos", "Coffee!"));
        list.add(createMockTalk("18:00", "Cómo usamos google para ganar dinero sin vender ni un juego", "Salón de actos", "Coffee!"));
        list.add(createMockTalk("19:00", "Afterparty & networking", "Salón de actos", "Coffee!"));

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
