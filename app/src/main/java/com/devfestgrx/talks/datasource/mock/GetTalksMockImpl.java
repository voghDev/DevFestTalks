/*
 * Copyright (C) 2016 Olmo Gallegos Hernández.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.devfestgrx.talks.datasource.mock;

import com.devfestgrx.talks.global.model.Talk;
import com.devfestgrx.talks.usecase.GetTalks;

import java.util.ArrayList;
import java.util.List;

public class GetTalksMockImpl implements GetTalks {
    @Override
    public void getTalks(Listener listener) {
        List<Talk> list = new ArrayList<Talk>();

        list.add(createMockTalk("24 Nov - 9:00", "GDG DevFest Granada 2016 Opening & Keynote", "Salón de actos", "Keynote"));
        list.add(createMockTalk("24 Nov - 9:30", "Wearables - Más allá de los smartwatches", "Salón de actos", "Los dispositivos \"vestibles\" están empezando a aparecer en el mercado. Los SmartWatches son los más difundidos y conocidos, y otros como las SmartGlasses van un poco más despacio. Pero que podemos encontrar en el mercado como tecnología \"vestible\". Hablaremos de los proyectos Jaqcuard y Verily en los que Google está involucrado y cual puede ser la opinión del mercado sobre toda esta tecnología."));
        list.add(createMockTalk("24 Nov - 10:30", "Coffee Break", "Cafetería", "Coffee!"));
        list.add(createMockTalk("24 Nov - 11:00", "Tensorflow: la IA detrás de Google", "Aula -1.2", ""));
        list.add(createMockTalk("24 Nov - 11:00", "¿Cómo trabaja un pro de Android? (O como trabajaría yo si fuera uno)", "Salón de actos", ""));
        list.add(createMockTalk("24 Nov - 12:00", "Material Design - A Glimpse Into the Future", "Salón de actos", ""));
        list.add(createMockTalk("24 Nov - 13:00", "Polymer: el fin a tus problemas con el front-end", "Salón de actos", ""));
        list.add(createMockTalk("24 Nov - 14:00", "Lunch", "Salón de actos", "Comidaaa!"));
        list.add(createMockTalk("24 Nov - 16:00", "Building our Fisher-Price Android architecture from scratch", "Aula -1.2", ""));
        list.add(createMockTalk("24 Nov - 16:00", "Microservices on Google Cloud Platform, the next generation of architectures.", "Salón de actos", ""));
        list.add(createMockTalk("24 Nov - 17:00", "Firebase", "Salón de actos", ""));
        list.add(createMockTalk("24 Nov - 18:00", "Cómo usamos google para ganar dinero sin vender ni un juego", "Salón de actos", ""));
        list.add(createMockTalk("24 Nov - 19:00", "Afterparty & networking", "Salón de actos", ""));

        list.add(createMockTalk("25 Nov - 9:00", "Cómo crear tecnología cloud computing con OpenNebula y OpenStack", "Salón de actos", ""));
        list.add(createMockTalk("25 Nov - 10:00", "Cómo crear tecnología cloud computing con OpenNebula y OpenStack", "Salón de actos", ""));
        list.add(createMockTalk("25 Nov - 10:30", "JJ Merelo", "Salón de actos", ""));
        list.add(createMockTalk("25 Nov - 10:30", "Codelab Firebase", "Aula -1.2", ""));
        list.add(createMockTalk("25 Nov - 11:30", "Juan Robles de Toro", "Salón de actos", ""));
        list.add(createMockTalk("25 Nov - 12:30", "Taller Progressive Web Apps", "Salón de actos", ""));
        list.add(createMockTalk("25 Nov - 13:30", "Cierre DevFest y sorteos", "Salón de actos", ""));

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
