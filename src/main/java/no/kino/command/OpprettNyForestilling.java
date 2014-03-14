package no.kino.command;

public class OpprettNyForestilling {
    private String navnPaaForestilling;
    private int antallPlasser;

    public OpprettNyForestilling(String navnPaaForestilling, int antallPlasser) {
        this.navnPaaForestilling = navnPaaForestilling;
        this.antallPlasser = antallPlasser;
    }

    public String getNavnPaaForestilling() {
        return navnPaaForestilling;
    }

    public int getAntallPlasser() {
        return antallPlasser;
    }

}
