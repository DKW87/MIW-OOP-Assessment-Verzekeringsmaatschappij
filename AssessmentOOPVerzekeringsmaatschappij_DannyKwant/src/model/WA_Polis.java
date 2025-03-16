package model;

import java.time.LocalDate;

public class WA_Polis extends Polis {

    // attributen

    private int aantalPersonen;

    // constructors

    public WA_Polis(String naamPolishouder, int verzekerdBedrag, LocalDate startDatum, int eigenRisicoCategorie, int aantalPersonen) {
        super(naamPolishouder, verzekerdBedrag, startDatum, eigenRisicoCategorie);
        this.aantalPersonen = aantalPersonen;
    }

    public WA_Polis(String naamPolishouder, int verzekerdBedrag) {
        this(naamPolishouder, verzekerdBedrag, LocalDate.now(), LAAG_RISICO_CATEGORIE, 1);
    }

    // methoden

    @Override
    public double berekenJaarPremie() {
        double jaarpremie = 0;
        final double CAT1_PERCENTAGE = 0.06;
        final double CAT2_PERCENTAGE = 0.05;
        final double CAT3_PERCENTAGE = 0.04;

        if (this.eigenRisicoCategorie == LAAG_RISICO_CATEGORIE) {
            jaarpremie += (this.verzekerdBedrag * CAT1_PERCENTAGE);
        } else if (this.eigenRisicoCategorie == MIDDEN_RISICO_CATEGORIE) {
            jaarpremie += (this.verzekerdBedrag * CAT2_PERCENTAGE);
        } else {
            jaarpremie += (this.verzekerdBedrag * CAT3_PERCENTAGE);
        }
        jaarpremie = jaarpremie * this.aantalPersonen;

        return jaarpremie;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append(super.toString().replace("Polis", "WA Polis"));
        strBuilder.append(String.format("\tAantal personen: %d %n", aantalPersonen));
        strBuilder.append(String.format("\tJaarpremie: %.2f euro %n", this.berekenJaarPremie()));

        return strBuilder.toString();
    }

} // klasse