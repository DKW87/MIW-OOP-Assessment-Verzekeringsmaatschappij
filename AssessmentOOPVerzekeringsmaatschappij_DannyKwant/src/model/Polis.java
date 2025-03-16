package model;

import java.time.LocalDate;

public abstract class Polis implements Comparable<Polis> {

    // attributen

    protected String naamPolishouder;
    protected int verzekerdBedrag;
    protected LocalDate startDatum;
    protected int eigenRisicoCategorie;
    protected final static int LAAG_RISICO_CATEGORIE = 1; //    final statics voor risico categoriën toegevoegd omdat deze
    protected final static int MIDDEN_RISICO_CATEGORIE = 2; //  veelvuldig terugkomen in Polis en subklassen WA_Polis en AutoPolis
    protected final static int HOOG_RISICO_CATEGORIE = 3;

    // constructors

    public Polis(String naamPolishouder, int verzekerdBedrag, LocalDate startDatum, int eigenRisicoCategorie) {
        this.naamPolishouder = naamPolishouder;
        this.verzekerdBedrag = verzekerdBedrag;
        this.startDatum = startDatum;
        this.setEigenRisicoCategorie(eigenRisicoCategorie);
    }

    // methoden

    public abstract double berekenJaarPremie();

    @Override
    public int compareTo(Polis anderePolis) {
        return this.startDatum.compareTo(anderePolis.startDatum);
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append(String.format("Polis is op naam van %s %n", naamPolishouder));
        strBuilder.append(String.format("\tVerzekerd bedrag: %d euro %n", verzekerdBedrag));
        strBuilder.append(String.format("\tStartdatum: %s %n", startDatum));
        strBuilder.append(String.format("\tEigenrisico categorie: %d %n", eigenRisicoCategorie));

        return strBuilder.toString();
    }

    // getters en setters

    public void setEigenRisicoCategorie(int eigenRisicoCategorie) {

        if (eigenRisicoCategorie >= LAAG_RISICO_CATEGORIE && eigenRisicoCategorie <= HOOG_RISICO_CATEGORIE) {
            this.eigenRisicoCategorie = eigenRisicoCategorie;
        } else {
            this.eigenRisicoCategorie = LAAG_RISICO_CATEGORIE;
            System.out.printf("%d is geen geldige invoer, dit moet 1 (laag-), 2 (midden-) of 3 (hoogrisico) zijn." +
                    "\nDeze waarde is op de standaardwaarde 'laagrisico <%d>' ingevoerd. %n", eigenRisicoCategorie, LAAG_RISICO_CATEGORIE);
        }
    }

} // klasse