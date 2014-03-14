package no.kino.command;



import no.kino.projections.ForestillingProjeksjon;
import no.kino.spring.SpringTestContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandHandlerIntegrasjonsTest extends SpringTestContext {
    private final String FORESTILLING = "Naboer";
    private ForestillingProjeksjon projeksjon = null;
    KinoCommandHandler commandHandler = null;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        commandHandler = ctx.getBean(KinoCommandHandler.class);
        projeksjon = ctx.getBean(ForestillingProjeksjon.class);
    }

    @Test
    public void testAtOpprettForestillingGirRiktigAntallSeter() throws Exception {
        commandHandler.handle(new OpprettNyForestilling(FORESTILLING,100));
        Assert.assertEquals(100, projeksjon.antallLedigeSeter(FORESTILLING).intValue());
    }

    @Test
    public void testAtReserverSeterGirRiktigAntallSeter() throws Exception {
        commandHandler.handle(new OpprettNyForestilling(FORESTILLING,100));
        commandHandler.handle(new ReserverSeter(FORESTILLING,2));
        Assert.assertEquals(98, projeksjon.antallLedigeSeter(FORESTILLING).intValue());
    }
}
