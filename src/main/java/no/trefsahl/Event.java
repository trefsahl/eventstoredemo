package no.trefsahl;

import org.joda.time.DateTime;


/**
 * Created by Tor Egil Refsahl on 05.02.14.
 */
public class Event {

    public Event () {
        timestamp = DateTime.now();
    }

    public DateTime timestamp;
    public String message;
    public String type;
}
