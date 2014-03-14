package no.kino;


import no.kino.event.EventStore;
import no.kino.event.ForestillingOpprettet;
import no.kino.event.SeterReservert;
import no.kino.projections.ForestillingProjeksjon;
import org.junit.Assert;
import org.junit.Test;


public class EventStoreBootstrapTest {

    @Test
    public void testAtEtEventKanLeggesTilFoerProjeksjonerLeggesTil() {
        EventStore eventStorage = new EventStore();
        eventStorage.addEvent(new ForestillingOpprettet("Film",1));
        ForestillingProjeksjon forestillingProjeksjon = new ForestillingProjeksjon();
        eventStorage.addListeningProjection(forestillingProjeksjon);
        Integer antallLedigeSeter = forestillingProjeksjon.antallLedigeSeter("Film");
        Assert.assertEquals(1, antallLedigeSeter.intValue());
    }

    @Test
    public void testAtFlereEventerKanLeggesTilFoerProjeksjonerLeggesTil() {
        EventStore eventStorage = new EventStore();
        eventStorage.addEvent(new ForestillingOpprettet("Film",10));
        eventStorage.addEvent(new SeterReservert("Film",1));
        ForestillingProjeksjon forestillingProjeksjon = new ForestillingProjeksjon();
        eventStorage.addListeningProjection(forestillingProjeksjon);
        Integer antallLedigeSeter = forestillingProjeksjon.antallLedigeSeter("Film");
        Assert.assertEquals(9, antallLedigeSeter.intValue());
    }
}
