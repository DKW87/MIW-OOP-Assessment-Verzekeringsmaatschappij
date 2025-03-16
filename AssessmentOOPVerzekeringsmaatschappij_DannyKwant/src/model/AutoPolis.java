package model;

import java.time.LocalDate;

public class AutoPolis extends Polis {

    // attributen

    private Auto auto;
    private int schadevrijeJaren;

    // constructors

    public AutoPolis(String naamPolishouder, int verzekerdBedrag, LocalDate startDatum, int eigenRisicoCategorie, Auto auto, int schadevrijeJaren) {
        super(naamPolishouder, verzekerdBedrag, startDatum, eigenRisicoCategorie);
        this.auto = auto;
        this.setSchadevrijeJaren(schadevrijeJaren);
    }

    // methoden

    @Override
    public double berekenJaarPremie() {
        double jaarpremie = 0;
        final double CAT1_PERCENTAGE = 0.10;
        final double CAT2_PERCENTAGE = 0.09;
        final double CAT3_PERCENTAGE = 0.08;
        final double KORTING_PER_JAAR = 0.05;
        final double MAX_KORTING = 0.70;
        final double MIN_BEDRAG = 0.30;

        if (this.eigenRisicoCategorie == LAAG_RISICO_CATEGORIE) {
            jaarpremie += (this.verzekerdBedrag * CAT1_PERCENTAGE);
        } else if (this.eigenRisicoCategorie == MIDDEN_RISICO_CATEGORIE) {
            jaarpremie += (this.verzekerdBedrag * CAT2_PERCENTAGE);
        } else {
            jaarpremie += (this.verzekerdBedrag * CAT3_PERCENTAGE);
        }

        if (this.schadevrijeJaren * KORTING_PER_JAAR >= MAX_KORTING) {
            jaarpremie *= MIN_BEDRAG;
        } else {
            jaarpremie = jaarpremie - ((this.schadevrijeJaren * KORTING_PER_JAAR) * jaarpremie);
        }

        return jaarpremie;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append(super.toString().replace("Polis", "Autopolis"));
        strBuilder.append(String.format("\tAuto: %s %n", auto));
        strBuilder.append(String.format("\tAantal schadevrije jaren: %d %n", schadevrijeJaren));
        strBuilder.append(String.format("\tJaarpremie: %.2f euro %n", this.berekenJaarPremie()));

        return strBuilder.toString();
    }

    // getters en setters


    public void setSchadevrijeJaren(int schadevrijeJaren) {
        final int MIN_SCHADEVRIJE_JAREN = 0;
        final int MAX_SCHADEVRIJE_JAREN = 40;

        if (schadevrijeJaren < MIN_SCHADEVRIJE_JAREN) {
            System.out.printf("%d is geen geldige invoer. Het aantal schadevrije jaren moet minimaal %d zijn!%n" +
                    "Deze waarde is op de standaardwaarde van '<%d> schadevrije jaren' ingevoerd.%n", schadevrijeJaren, MIN_SCHADEVRIJE_JAREN, MIN_SCHADEVRIJE_JAREN);
            this.schadevrijeJaren = MIN_SCHADEVRIJE_JAREN;

        } else if (schadevrijeJaren > MAX_SCHADEVRIJE_JAREN) {
            System.out.printf("%d is geen geldige invoer. Het aantal schadevrije jaren mag maximaal %d zijn!%n" +
                    "Deze waarde is op de standaardwaarde van '<%d> schadevrije jaren' ingevoerd.%n", schadevrijeJaren, MAX_SCHADEVRIJE_JAREN, MIN_SCHADEVRIJE_JAREN);
            this.schadevrijeJaren = MIN_SCHADEVRIJE_JAREN;
        } else {
            this.schadevrijeJaren = schadevrijeJaren;
        }
    }

} // klasse