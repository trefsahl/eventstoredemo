package no.kino.command;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReserverSeter{
    private String forestilling;
    private int reserverteSeter;

    public ReserverSeter() {
    }

    public ReserverSeter(String forestilling, int reserverteSeter) {
        this.forestilling = forestilling;
        this.reserverteSeter = reserverteSeter;
    }

    public String getForestilling() {
        return forestilling;
    }

    public int getReserverteSeter() {
        return reserverteSeter;
    }


}
