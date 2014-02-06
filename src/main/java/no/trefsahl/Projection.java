package no.trefsahl;

/**
 * Created by Tor Egil Refsahl on 06.02.14.
 */
public class Projection {

    public String getBusinessinfo() {
        return businessinfo;
    }

    private String businessinfo = "";

    public void eventAdded(Event incomingEvent) {
        businessinfo += "Type:" + incomingEvent.type + " Message:"  + incomingEvent.message  + "\n";
    }

}
