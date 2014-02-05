package no.trefsahl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EventStore eventStorage = new EventStore();

        Event event1 = new Event();
        event1.message = "Just an event";
        event1.type = "Event type";

        eventStorage.addEvent(event1);

        System.out.println("Size of eventstorage = " + eventStorage.size());
    }
}
