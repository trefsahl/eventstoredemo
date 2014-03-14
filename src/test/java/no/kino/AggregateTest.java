package no.kino;

import no.kino.domain.ForestillingAggregate;
import no.kino.event.ForestillingOpprettet;
import no.kino.event.SeterReservert;
import org.junit.Assert;
import org.junit.Test;

public class AggregateTest {


    private final String FILM = "Donnie Darko";

    @Test
    public void testAtSeterReservertIkkeKanSkjeHvisForestillingIkkeErOpprettet() {
        ForestillingAggregate forestillingAggregate = new ForestillingAggregate();
        SeterReservert reservarsjon = new SeterReservert(FILM, 5);
        Assert.assertFalse(forestillingAggregate.kanSeteReserveres(reservarsjon));
    }

    @Test
    public void testAtSeterReservertKanSkjeHvisForestillingErOpprettet() {
        ForestillingAggregate forestillingAggregate = new ForestillingAggregate();
        ForestillingOpprettet forestillingOpprettet = new ForestillingOpprettet(FILM, 10);
        SeterReservert reservarsjon = new SeterReservert(FILM, 5);
        forestillingAggregate.eventAdded(forestillingOpprettet);
        Assert.assertTrue(forestillingAggregate.kanSeteReserveres(reservarsjon));
    }

    @Test
    public void testAtForMangeSeterReservertIkkeErLov() {
        ForestillingAggregate forestillingAggregate = new ForestillingAggregate();
        ForestillingOpprettet forestillingOpprettet = new ForestillingOpprettet(FILM, 10);
        SeterReservert reservarsjon =  new SeterReservert(FILM, 15);
        forestillingAggregate.eventAdded(forestillingOpprettet);
        forestillingAggregate.eventAdded(reservarsjon);
        Assert.assertFalse(forestillingAggregate.kanSeteReserveres(reservarsjon));
    }

    @Test
    public void testAtSammeFilmIkkeKanBliOpprettetToGanger() {
        ForestillingOpprettet forestillingOpprettet = new ForestillingOpprettet(FILM, 10);
        ForestillingAggregate forestillingAggregate = new ForestillingAggregate();
        ForestillingOpprettet forestillingOpprettet2 = new ForestillingOpprettet(FILM, 10);
        forestillingAggregate.eventAdded(forestillingOpprettet);
        Assert.assertFalse(forestillingAggregate.kanForestillingOpprettes(forestillingOpprettet2));

    }
}
