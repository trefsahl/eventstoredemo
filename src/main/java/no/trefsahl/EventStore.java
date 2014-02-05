package no.trefsahl;

import java.util.ArrayList;

/**
 * Created by Tor Egil Refsahl on 05.02.14.
 */
public class EventStore {
    private ArrayList<Event> eventStorage;

    public EventStore(){
        eventStorage = new ArrayList<Event>();
    }

    public void addEvent(Event incomingEvent) {
        eventStorage.add(incomingEvent);
    }

    public int size() {
        return eventStorage.size();
    }

    public ArrayList<Event> getEventStorage() {
        return eventStorage;
    }
}
