package no.kino;

import no.kino.event.EventStore;
import no.kino.event.ForestillingOpprettet;
import no.kino.event.SeterReservert;

public class ForestillingService {

    private final EventStore eventStore;

    public ForestillingService(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public void opprettForestilling(String film, int antallSeter) {
        eventStore.addEvent(new ForestillingOpprettet(film, antallSeter));
    }

    public void reserverSeter(String film, int antallSeter) {
        eventStore.addEvent(new SeterReservert(film, antallSeter));
    }
}
