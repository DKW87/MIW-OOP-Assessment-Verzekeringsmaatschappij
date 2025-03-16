package model;

public class Auto {

    // attributen

    private String kenteken;
    private String merk;
    private String type;

    // constructors

    public Auto(String kenteken, String merk, String type) {
        this.kenteken = kenteken;
        this.merk = merk;
        this.type = type;
    }

    // methoden

    @Override
    public String toString() {
        return String.format("%s %s met %s", merk, type, kenteken);
    }

} // klasse