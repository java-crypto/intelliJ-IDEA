package com.mkyong.hashing;

/*
 * Herkunft/Origin: http://javacrypto.bplaced.net/
 * Programmierer/Programmer: Mkyong
 * Description: https://mkyong.com/maven/how-to-create-a-java-project-with-maven/
 * Original source: https://github.com/mkyong/maven-examples
 * Copyright/Copyright: Mkyong
 * Lizenttext/Licence: MIT https://choosealicense.com/licenses/mit/
 * getestet mit/tested with: Java Runtime Environment 11.0.5 x64
 * verwendete IDE/used IDE: intelliJ IDEA 2019.3.4
 * Datum/Date (dd.mm.jjjj): 31.03.2020
 * Funktion: Erzeugt einen SHA256-Hash von einem String
 * Function: Creates a SHA256-hash of a string
 *
 * Sicherheitshinweis/Security notice
 * Die Programmroutinen dienen nur der Darstellung und haben keinen Anspruch auf eine korrekte Funktion,
 * insbesondere mit Blick auf die Sicherheit !
 * Prüfen Sie die Sicherheit bevor das Programm in der echten Welt eingesetzt wird.
 * The program routines just show the function but please be aware of the security part -
 * check yourself before using in the real world !
 *
 * Sie benötigen zwei Bibliotheken, die mit dem Ivy-Skript ivy.xml  heruntergeladen werden
 * You need two libraries that get downloaded via the Ivy-Script ivy.xml
 * verwendete BitcoinJ-Bibliothek / used BitcoinJ Library: bitcoinj-core-0.15.6.jar
 */

import org.junit.Assert;
import org.junit.Test;

public class AppTest {
    private String INPUT = "123456";
    @Test
    public void testLength() {
        Assert.assertEquals(64, App.sha256hex(INPUT).length());
    }
    @Test
    public void testHex() {
        String expected = "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92";
        Assert.assertEquals(expected, App.sha256hex(INPUT));
    }
}