package no.trefsahl;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Tor Egil Refsahl on 05.02.14.
 */
@RunWith(JUnit4.class)
public class EventStoreTest {

    private static String MESSAGE = "A message";

    @Test
    public void eventShouldBeAddedToStorage(){
        Event newEvent = createNewEvent();
        EventStore storage = new EventStore();
        storage.addEvent(newEvent);
        assertEquals(storage.size(), 1);
    }

    private Event createNewEvent() {
        Event newEvent = new Event();
        newEvent.message = MESSAGE;
        newEvent.type = "Event type";
        return newEvent;
    }

    @Test
    public void projectionShouldHaveBeenNotified() {
        Event newEvent = createNewEvent();
        Projection aTestProjection = new Projection();
        EventStore storage = new EventStore();
        storage.addListeningProjection(aTestProjection);
        storage.addEvent(newEvent);
        assertTrue(aTestProjection.getBusinessinfo().contains(MESSAGE));

    }
}
