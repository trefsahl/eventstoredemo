package no.kino.spring;

import no.kino.event.EventStore;
import no.kino.projections.ForestillingProjeksjon;
import no.kino.web.Filmprogram;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

/**
 * Created by mariwien on 24/02/14.
 */
public class SpringConfigTest {

    @Test
    public void sjekkAtSpringConfigFungerer () {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SpringConfig.class);
        ctx.refresh();

        Assert.assertNotNull(ctx.getBean(Filmprogram.class));
        Assert.assertNotNull(ctx.getBean(EventStore.class));

        //System.out.println(filmprogram.foo());

    }

}
