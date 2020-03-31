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

import org.apache.commons.codec.digest.DigestUtils;
public class App {
    public static void main(String[] args) {
        String string = "java-crypto.bplaced.net";
        System.out.println("The SHA256-Hash for " + string + " is\n" + sha256hex(string));
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
