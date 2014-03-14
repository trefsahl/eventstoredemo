package no.kino.command;

import no.kino.spring.SpringTestContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CommandHandlerTest extends SpringTestContext{

    private static final String FORESTILLING = "Matrix";
    private KinoCommandHandler kinoCommandHandler =null;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        kinoCommandHandler = ctx.getBean(KinoCommandHandler.class);
    }

    @Test
    public void OppretteNyForestillingSkalFungere() {
        OpprettNyForestilling opprettNyForestilling = new OpprettNyForestilling(FORESTILLING,10);
        Assert.assertTrue(kinoCommandHandler.handle(opprettNyForestilling));
    }


    @Test
    public void OppretteToLikeForestillingerSkalIkkeFungere() {
        OpprettNyForestilling opprettNyForestilling = new OpprettNyForestilling(FORESTILLING,10);
        OpprettNyForestilling opprettNyForestilling2 = new OpprettNyForestilling(FORESTILLING,10);
        kinoCommandHandler.handle(opprettNyForestilling);
        Assert.assertFalse(kinoCommandHandler.handle(opprettNyForestilling2));
    }

}
