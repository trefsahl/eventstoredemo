package no.kino.event;


public class SeterReservert implements Event {

    private final String navn;
    private final Integer antallPlasser;

    public SeterReservert(String navn, Integer antallPlasser) {
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
        return "Film:" + navn + ", Antall plasser reservert:" + antallPlasser;
    }
}
