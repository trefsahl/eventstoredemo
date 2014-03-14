package no.kino.event;


public class ForestillingOpprettet implements Event {

    private final String navn;
    private final Integer antallPlasser;

    public ForestillingOpprettet(String navn, Integer antallPlasser) {
        this.navn = navn;
        this.antallPlasser = antallPlasser;
    }

    public String getFilm() {
        return navn;
    }

    public Integer getAntallSeter() {
        return antallPlasser;
    }

    public String toString() {
        return "Film opprettet:" + navn + ", Antall plasser:" + antallPlasser;
    }
}
