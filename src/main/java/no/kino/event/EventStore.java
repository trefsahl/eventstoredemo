package no.kino.event;

import no.kino.projections.Projection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EventStore {
    private ArrayList<Event> eventStorage;
    private Set<Projection> listeningProjections;

    public EventStore(){
        eventStorage = new ArrayList<>();
        listeningProjections = new HashSet<>();
    }

    public  void addListeningProjection(Projection projection) {
        listeningProjections.add(projection);
        spillAvHistoriskeEventer(projection);
    }

    private void spillAvHistoriskeEventer(Projection projection) {
        for (Event event : eventStorage) {
            projection.eventAdded(event);
        }
    }

    public void addEvent(Event incomingEvent) {
        eventStorage.add(incomingEvent);
        for (Projection projection: listeningProjections) {
            projection.eventAdded(incomingEvent);
        }
    }

    public int size() {
        return eventStorage.size();
    }

}
