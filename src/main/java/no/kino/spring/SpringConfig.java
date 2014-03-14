package no.kino.spring;

import no.kino.domain.ForestillingAggregate;
import no.kino.event.EventStore;
import no.kino.projections.ForestillingProjeksjon;
import no.kino.web.SSEResource;
import org.glassfish.jersey.media.sse.SseBroadcaster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@Configuration
@ComponentScan(basePackages = {
        "no.kino.event",
        "no.kino.projections",
        "no.kino.web",
        "no.kino.command",
        "no.kino.domain"})
public class SpringConfig {

    @PostConstruct
    public void initEventStore() {
        EventStore eventStore = getEventStore();
        eventStore.addListeningProjection(getForestillingAggregate());
        eventStore.addListeningProjection(getForestillingProjeksjon());
        eventStore.addListeningProjection(getServerSideEventResource());
    }

    public @Bean ForestillingAggregate getForestillingAggregate() {
        return new ForestillingAggregate();
    }

    public @Bean EventStore getEventStore() {
        return new EventStore();
    }

    public @Bean ForestillingProjeksjon getForestillingProjeksjon(){
        return new ForestillingProjeksjon();
    }

    public @Bean SSEResource getServerSideEventResource() {
        return new SSEResource();
    }

    public @Bean SseBroadcaster getBroadcaster() {
        return new SseBroadcaster();
    }
}
