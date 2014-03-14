package no.kino;

import no.kino.event.EventStore;
import no.kino.projections.ForestillingProjeksjon;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertEquals;

    @RunWith(JUnit4.class)
public class EventStoreTest {

    private ForestillingProjeksjon forestillingProjeksjon;
    private EventStore eventStorage;

    private static String FILM = "Donnie Darko";

    @Before
    public void setUp() throws Exception {
        eventStorage = new EventStore();
        forestillingProjeksjon = new ForestillingProjeksjon();
        eventStorage.addListeningProjection(forestillingProjeksjon);
    }

    @Test
    public void testOpprettingAvForestillingGirAntallSeterTilgjengelig() throws Exception {
        ForestillingService forestillingService = new ForestillingService(eventStorage);
        forestillingService.opprettForestilling(FILM, 100);

        Integer antallLedigeSeter = forestillingProjeksjon.antallLedigeSeter(FILM);
        assertEquals(antallLedigeSeter.intValue(), 100);

    }

    @Test
    public void testOpprettingAvForestillingOgEnReservasjonGirAntallSeterTilgjengelig() throws Exception {
        ForestillingService forestillingService = new ForestillingService(eventStorage);

        forestillingService.opprettForestilling(FILM, 100);
        forestillingService.reserverSeter(FILM, 3);

        Integer antallLedigeSeter = forestillingProjeksjon.antallLedigeSeter(FILM);
        assertEquals(antallLedigeSeter.intValue(), 97);
    }

    @Test
    public void testOpprettingAvForestillingOgToReservasjonGirAntallSeterTilgjengelig() throws Exception {
        ForestillingService forestillingService = new ForestillingService(eventStorage);
        forestillingService.opprettForestilling(FILM, 100);
        forestillingService.reserverSeter(FILM, 3);
        forestillingService.reserverSeter(FILM, 2);

        Integer antallLedigeSeter = forestillingProjeksjon.antallLedigeSeter(FILM);
        assertEquals(antallLedigeSeter.intValue(), 95);
    }

    @Test
    public void testFullForestillingGirFeilmelding() throws Exception {
        ForestillingService forestillingService = new ForestillingService(eventStorage);
        forestillingService.opprettForestilling(FILM, 100);
        forestillingService.reserverSeter(FILM, 100);
        forestillingService.reserverSeter(FILM, 2);
    }

}
