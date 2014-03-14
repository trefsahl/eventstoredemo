package no.kino.projections;


import no.kino.event.ForestillingOpprettet;
import no.kino.event.SeterReservert;
import no.kino.spring.SpringTestContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class ForestillingProjeksjonTest extends SpringTestContext {

    private final String FORESTILLING = "Død snø";
    private final String FORESTILLING2 = "Død snø 2";

    private ForestillingProjeksjon forestilling = null;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        forestilling = ctx.getBean(ForestillingProjeksjon.class);
    }

    @Test
    public void testAtAntallSeterErRiktigEtterOpprettetForestilling(){

        forestilling.eventAdded(new ForestillingOpprettet(FORESTILLING, 30));
        Integer antallLedigeSeter = forestilling.antallLedigeSeter(FORESTILLING);
        Assert.assertEquals(30, antallLedigeSeter.intValue());
    }

    @Test
    public void testAtAntallSeterErRiktigEtterBestillingAvSeter(){
        forestilling.eventAdded(new ForestillingOpprettet(FORESTILLING, 30));
        forestilling.eventAdded(new SeterReservert(FORESTILLING, 10));

        Integer antallLedigeSeter = forestilling.antallLedigeSeter(FORESTILLING);
        Assert.assertEquals("Antall ledige seter", 30-10, antallLedigeSeter.intValue());
    }

    @Test
    public void testAtAlleForestillingerBlirListetUt() {
        forestilling.eventAdded(new ForestillingOpprettet(FORESTILLING, 30));
        forestilling.eventAdded(new ForestillingOpprettet(FORESTILLING2, 30));
        HashMap<String,Film> stringFilmHashMap = forestilling.listAlleForestillinger();
        Assert.assertEquals("Antall filmer er riktig", 2, stringFilmHashMap.size());
    }


}
