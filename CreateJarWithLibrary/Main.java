/*
 * Herkunft/Origin: http://java-crypto.bplaced.net/
 * Programmierer/Programmer: Michael Fehr
 * Copyright/Copyright: frei verwendbares Programm (Public Domain)
 * Copyright: This is free and unencumbered software released into the public domain.
 * Lizenttext/Licence: <http://unlicense.org>
 * getestet mit/tested with: Java Runtime Environment 11.0.5 x64
 * verwendete IDE/used IDE: intelliJ IDEA 2019.3.1
 * Datum/Date (dd.mm.jjjj): 08.01.2020
 * Funktion: intelliJ JAR Erzeugung mit externer Bibliothek
 * Function: intelliJ JAR creation with external library
 *
 * Hinweis/Notice
 * Sie benoetigen intelliJ um das Programm uebersetzen und ausfuehren zu koennen
 * You need intelliJ to build and run the program
 *
 * Sie erhalten die externe Bibliothek unter diesem Link:
 * You get the external library with this link;
 * joda-time: https://mvnrepository.com/artifact/joda-time/joda-time
 */

import org.joda.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World Create JAR with unsigned library");
        LocalDate ld = new LocalDate(2020, 1, 8);
        System.out.println("Datum:" + ld +
                "\nDatums-Tag in Deutsch:" + ld.dayOfWeek().getAsText(Locale.GERMANY) +
                "\nDatums-Monat in Deutsch:" + ld.monthOfYear().getAsText(Locale.GERMANY));
        System.out.println("Datum:" + ld +
                "\nDatums-Tag in Französisch:" + ld.dayOfWeek().getAsText(Locale.FRANCE) +
                "\nDatums-Monat in Französisch:" + ld.monthOfYear().getAsText(Locale.FRANCE));

    }
}
