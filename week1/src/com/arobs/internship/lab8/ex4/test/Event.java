package com.arobs.internship.week1.lab8.ex4.test;

abstract class Event {

    EventType type;

    Event(EventType type) {
        this.type = type;
    }

    EventType getType() {
        return type;
    }

}