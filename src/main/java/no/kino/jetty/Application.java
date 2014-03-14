package no.kino.jetty;


import org.glassfish.jersey.media.sse.SseFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class Application extends ResourceConfig {

    public Application() {
        register(SseFeature.class);
        packages("no.kino");
    }

}
