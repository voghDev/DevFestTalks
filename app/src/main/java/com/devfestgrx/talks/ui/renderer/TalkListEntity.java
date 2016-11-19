package com.devfestgrx.talks.ui.renderer;

import com.devfestgrx.talks.global.model.Talk;

public class TalkListEntity extends ListEntity {
    Talk talk;

    public Talk getTalk() {
        return talk;
    }

    public void setTalk(Talk talk) {
        this.talk = talk;
    }

    public TalkListEntity(Talk talk) {

        this.talk = talk;
    }
}