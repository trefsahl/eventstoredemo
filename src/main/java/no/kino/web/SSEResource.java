package no.kino.web;

import no.kino.event.Event;
import no.kino.event.ForestillingOpprettet;
import no.kino.event.SeterReservert;
import no.kino.projections.Projection;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;
import org.glassfish.jersey.media.sse.SseFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Service
@Path("events")
public class SSEResource implements Projection {

    @Autowired
    private SseBroadcaster broadcaster;

    @GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput attachToEventProjeksjon() {
        EventOutput eventOutput = new EventOutput();
        this.broadcaster.add(eventOutput);
        return eventOutput;
    }

    @Override
    public void eventAdded(Event event) {
        OutboundEvent.Builder eventBuilder = new OutboundEvent.Builder();
        OutboundEvent outboundEvent = null;

        if (event instanceof SeterReservert) {
            SeterReservert seterReservert = (SeterReservert) event;
            outboundEvent = eventBuilder
                    .mediaType(MediaType.TEXT_PLAIN_TYPE)
                    .data(String.class, seterReservert.toString())
                    .build();

        } else if (event instanceof ForestillingOpprettet) {
            ForestillingOpprettet forestillingOpprettet = (ForestillingOpprettet) event;
            outboundEvent = eventBuilder
                    .mediaType(MediaType.TEXT_PLAIN_TYPE)
                    .data(String.class, forestillingOpprettet.toString())
                    .build();
        }
        broadcaster.broadcast(outboundEvent);
    }
}
