package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Verzekeringskantoor {

    // attributen

    private String naam;
    private String plaats;
    private List<Polis> polissen;

    // constructors

    public Verzekeringskantoor(String naam, String plaats) {
        this.naam = naam;
        this.plaats = plaats;
        this.polissen = new ArrayList<>();
    }

    // methoden

    public void voegPolisToe(Polis polis) {
        this.polissen.add(polis);
    }

    @Override
    public String toString() {
        Collections.sort(polissen);
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append(String.format("Polissen op verzekeringskantoor %s the %s: %n", naam, plaats));

        if (polissen.isEmpty()) {
            strBuilder.append(String.format("Geen polissen gevonden. Voeg deze eerst toe. %n"));
        } else {
            for (Polis polis : polissen) {
                strBuilder.append(polis.toString());
                strBuilder.append("\n");
            }
        }

        return strBuilder.toString();
    }

} // klasse