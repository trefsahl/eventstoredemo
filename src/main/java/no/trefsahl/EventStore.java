package no.trefsahl;

import java.util.ArrayList;

/**
 * Created by Tor Egil Refsahl on 05.02.14.
 */
public class EventStore {
    private ArrayList<Event> eventStorage;
    private ArrayList<Projection> listeingProjections;

    public EventStore(){
        eventStorage = new ArrayList<>();
        listeingProjections = new ArrayList<>();
    }

    public  void addListeningProjection(Projection projection) {
        listeingProjections.add(projection);
    }

    public void addEvent(Event incomingEvent) {
        eventStorage.add(incomingEvent);
        for (Projection projection:listeingProjections) {
            projection.eventAdded(incomingEvent);
        }
    }

    public int size() {
        return eventStorage.size();
    }

}
