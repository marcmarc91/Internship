package com.arobs.internship.week1.lab8.ex4.test;

class NoEvent extends Event{

    NoEvent() {
        super(EventType.NONE);
    }

    @Override
    public String toString() {
        return "NoEvent{}";
    }
}