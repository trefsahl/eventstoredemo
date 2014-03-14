package no.kino.domain;

import no.kino.event.Event;
import no.kino.event.ForestillingOpprettet;
import no.kino.event.SeterReservert;
import no.kino.projections.Projection;

import java.util.HashMap;

public class ForestillingAggregate implements Projection {

    HashMap<String, Integer> forestillinger = new HashMap<>();

    public boolean kanSeteReserveres(SeterReservert seterReservert) {
        return forestillinger.containsKey(seterReservert.getFilm())
                && forestillinger.get(seterReservert.getFilm())>0;
    }

    @Override
    public void eventAdded(Event event) {

        if (event instanceof ForestillingOpprettet) {
            ForestillingOpprettet forestillingOpprettet = (ForestillingOpprettet) event;
            forestillinger.put(forestillingOpprettet.getFilm(), forestillingOpprettet.getAntallSeter());

        } else if (event instanceof SeterReservert) {
            SeterReservert seterReservert = (SeterReservert) event;
            Integer forestilling = forestillinger.get(seterReservert.getFilm());
            int antallTilgjengeligePlasser = forestilling - seterReservert.getAntallSeter();
            forestillinger.put(seterReservert.getFilm(), antallTilgjengeligePlasser);
        }
    }

    public boolean kanForestillingOpprettes(ForestillingOpprettet forestillingOpprettet) {
        return !forestillinger.containsKey(forestillingOpprettet.getFilm());
    }
}
