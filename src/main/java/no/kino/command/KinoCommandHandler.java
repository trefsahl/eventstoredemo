package no.kino.command;

import no.kino.domain.ForestillingAggregate;
import no.kino.event.EventStore;
import no.kino.event.ForestillingOpprettet;
import no.kino.event.SeterReservert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class KinoCommandHandler {

    @Autowired
    private EventStore eventStore;

    @Autowired
    private ForestillingAggregate forestillingAggregate;


    public boolean handle(OpprettNyForestilling opprettNyForestilling) {
        ForestillingOpprettet forestillingOpprettet = new ForestillingOpprettet(opprettNyForestilling.getNavnPaaForestilling(), opprettNyForestilling.getAntallPlasser());
        if(forestillingAggregate.kanForestillingOpprettes(forestillingOpprettet)) {
            eventStore.addEvent(forestillingOpprettet);
            return true;
        }
        return false;
    }


    public boolean handle(ReserverSeter reserverSeter) {
        SeterReservert seterReservert = new SeterReservert(reserverSeter.getForestilling(), reserverSeter.getReserverteSeter());
        if(forestillingAggregate.kanSeteReserveres(seterReservert)){
            eventStore.addEvent(seterReservert);
            return true;
        }
        return false;
    }
}
