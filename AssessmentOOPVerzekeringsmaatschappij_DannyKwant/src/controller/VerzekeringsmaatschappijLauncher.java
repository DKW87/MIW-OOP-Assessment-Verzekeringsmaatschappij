package controller;

import model.*;

import java.time.LocalDate;

/* Verzekeringsmaatschappij Snits gaat digitaliseren.
Dit programma is ontwikkeld om gegevens betreffende polissen en schadeclaims vast te leggen.
In de main wordt de werking getest van de klassen die nodig zijn voor deze applicatie.
Mbv begeleidende tekst in de output van dit programma wordt er uitgelegd wat er precies gebeurd.
Programma geschreven door: Danny Kwant */
public class VerzekeringsmaatschappijLauncher {

    public static void main(String[] args) {

        System.out.println("Dit is de uitwerking van Danny Kwant met studentnummer 500955184.\n");

        System.out.println("Allereerst maken we in de code 4 polissen aan dmv een constructor. 2 autopolissen en 2 wa polissen.\n" +
                "Als daar incorrecte waardes zijn ingevuld, komt er een foutmelding terug.");

        System.out.println(); // lege regel voor duidelijkheid

        AutoPolis mijnEersteAutoPolis = new AutoPolis("Danny", 10000, LocalDate.now(),
                1, new Auto("XR-123-TZ", "Tesla", "Model S"), -15);
        AutoPolis mijnTweedeAutoPolis = new AutoPolis("Wammes Waggel", 10000, LocalDate.of(2021, 7, 31),
                2, new Auto("74-OBB-3", "Volkswagen", "Kever"), 8);
        WA_Polis mijnEersteWAPolis = new WA_Polis("Tom Poes", 1000000, LocalDate.of(2021, 9, 1),
                1, 4);
        WA_Polis mijnTweedeWAPolis = new WA_Polis("Gerben", 5000, LocalDate.now(),
                4, 12);

        System.out.println(); // lege regel voor duidelijkheid

        System.out.println("Dit gebeurt ook wanneer we de set methode aanspreken. De constructor hierboven maakte dus gebruik van die methode." +
                "\nLaten we de set methode aanroepen met een te hoog aantal schadevrijejaren om ook die te laten zien:");

        System.out.println(); // lege regel voor duidelijkheid

        mijnEersteAutoPolis.setSchadevrijeJaren(99);

        System.out.println(); // lege regel voor duidelijkheid

        System.out.println("Tot slot laat ik zien dat alle toString() methodes accuraat zijn geïmplementeerd door polissen aan een kantoor te koppelen." +
                "\nLaten we eerst een verzekeringskantoor aanmaken en zien wat er gebeurt!");

        System.out.println(); // lege regel voor duidelijkheid

        Verzekeringskantoor mijnVerzekeringskantoor = new Verzekeringskantoor("Bommelstein", "Rommeldam");

        System.out.println(mijnVerzekeringskantoor);

        System.out.println(); // lege regel voor duidelijkheid

        System.out.println("Oh ja, we moeten nog wel even de polissen toevoegen aan het verzekeringskantoor!" +
                "\n Laten we het nog eens proberen!");

        mijnVerzekeringskantoor.voegPolisToe(mijnEersteAutoPolis);
        mijnVerzekeringskantoor.voegPolisToe(mijnTweedeAutoPolis);
        mijnVerzekeringskantoor.voegPolisToe(mijnTweedeWAPolis);
        mijnVerzekeringskantoor.voegPolisToe(mijnEersteWAPolis);

        System.out.println(); // lege regel voor duidelijkheid

        System.out.print(mijnVerzekeringskantoor);

        System.out.println("Je ziet ook dat de lijst gesorteerd is op datum. \n" +
                "Alvast bedankt voor het nakijken! :-)");


    } // main

} // klasse