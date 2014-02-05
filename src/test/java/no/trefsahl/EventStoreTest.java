package no.trefsahl;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Tor Egil Refsahl on 05.02.14.
 */
@RunWith(JUnit4.class)
public class EventStoreTest {

    @Test
    public void EventShouldBeAddedToStorage(){
        Event newEvent = new Event();
        newEvent.message = "A message";
        newEvent.type = "Event type";

        EventStore storage = new EventStore();
        storage.addEvent(newEvent);
        assertEquals(storage.size(), 1);
    }
}
