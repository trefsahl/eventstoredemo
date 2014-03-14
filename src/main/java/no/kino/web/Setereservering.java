package no.kino.web;

import no.kino.command.KinoCommandHandler;
import no.kino.command.OpprettNyForestilling;
import no.kino.command.ReserverSeter;
import no.kino.projections.Film;
import no.kino.projections.ForestillingProjeksjon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Service
@Path("setereservering")
public class Setereservering {

    @Autowired
    public ForestillingProjeksjon forestillinger;

    @Autowired
    public KinoCommandHandler kinoCommandHandler;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void reserverSete(ReserverSeter reserverSeter){
        kinoCommandHandler.handle(reserverSeter);
    }

}
