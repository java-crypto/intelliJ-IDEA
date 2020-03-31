
/*
 * Herkunft/Origin: http://javacrypto.bplaced.net/
 * Programmierer/Programmer: Michael Fehr
 * Copyright/Copyright: frei verwendbares Programm (Public Domain)
 * Copyright: This is free and unencumbered software released into the public domain.
 * Lizenttext/Licence: <http://unlicense.org>
 * getestet mit/tested with: Java Runtime Environment 11.0.5 x64
 * verwendete IDE/used IDE: intelliJ IDEA 2019.3.4
 * Datum/Date (dd.mm.jjjj): 31.03.2020
 * Funktion: Konvertiert eine Maven pom.xml-Datei in eine Ivy ivy.xml-Datei
 * Function: converts a Maven pom.xml file to a Ivy ivy.xml file
 *
 * Sicherheitshinweis/Security notice
 * Die Programmroutinen dienen nur der Darstellung und haben keinen Anspruch auf eine korrekte Funktion,
 * insbesondere mit Blick auf die Sicherheit !
 * Prüfen Sie die Sicherheit bevor das Programm in der echten Welt eingesetzt wird.
 * The program routines just show the function but please be aware of the security part -
 * check yourself before using in the real world !
 *
 */

import java.io.*;

public class PomToIvyConverter {
    public static void main(String[] args) throws IOException {
        System.out.println("POM.xml to IVY.xml converter");
        String pomFilename = "pom.xml";
        String ivyFilename = "ivy.xml";
        File pomFile = new File(pomFilename);
        File ivyFile = new File(ivyFilename);
        boolean verbose = false; // true = ausgabe auf dem bildschirm
        System.out.println("Die Datei " + pomFilename + " ist vorhanden: " + pomFile.exists());
        if (!pomFile.exists()) {
            System.out.println("Die Datei " + pomFilename + " ist nicht vorhanden. Das Programm wird beendet");
            System.exit(0);
        }
        System.out.println("Die Datei " + ivyFilename + " ist vorhanden: " + ivyFile.exists());
        if (ivyFile.exists()) {
            System.out.println("Die Datei " + ivyFilename + " wird geloescht");
            ivyFile.delete();
            System.out.println("Die Datei " + ivyFilename + " ist vorhanden: " + ivyFile.exists());
        }
        // pom-file is existing and ivy-file is not existing
        boolean startDependency = false;
        boolean startGroupId = false;
        String valueGroupId = "";
        boolean startArtifactId = false;
        String valueArtifactId = "";
        boolean startVersion = false;
        String valueVersion = "";
        boolean startComment = false;
        boolean writeDependency = false;

        BufferedReader in = null;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(ivyFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // write header
        writer.write("<ivy-module version=\"2.0\">" + "\n");
        writer.write("    <info organisation=\"Demo Application\" module=\"App\"/>" + "\n");
        writer.write("    <dependencies>" + "\n");

        int lineRead = 0; //
        in = null;
        String readZeile = "";
        try {
            in = new BufferedReader(new FileReader(pomFile));
            while ((readZeile = in.readLine()) != null) {
                lineRead++;
                readZeile = readZeile.trim();
                if (verbose) {System.out.println("Zeile " + lineRead + ":" + readZeile);}
                if (readZeile.contains("<dependency>")) {
                    startDependency = true;
                    startGroupId = false;
                    startArtifactId = false;
                    startVersion = false;
                }
                if (readZeile.contains("</dependency>")) {
                    startDependency = false;
                }
                if (readZeile.contains("<groupId>")) {
                    startGroupId = true;
                }
                if (readZeile.contains("<artifactId>")) {
                    startArtifactId = true;
                }
                if (readZeile.contains("<version>")) {
                    startVersion = true;
                }
                if (readZeile.contains("<!--")) {
                    startComment = true;
                }
                if (readZeile.contains("-->")) {
                    startComment = false;
                }
                // start the conversion
                // get the groupId
                if (startComment == false & startDependency == true & startGroupId == true) {
                    valueGroupId = getStringBeetween(readZeile, "<groupId>", "</groupId>");
                    if (verbose) {System.out.println("groupId: " + valueGroupId);}
                    startGroupId = false;
                }
                if (startComment == false & startDependency == true & startArtifactId == true) {
                    valueArtifactId = getStringBeetween(readZeile, "<artifactId>", "</artifactId>");
                    if (verbose) { System.out.println("artifactId: " + valueArtifactId);}
                    startArtifactId = false;
                }
                if (startComment == false & startDependency == true & startVersion == true) {
                    valueVersion = getStringBeetween(readZeile, "<version>", "</version>");
                    if (verbose) { System.out.println("version: " + valueVersion);}
                    startVersion = false;
                    writeDependency = true;
                }
                if (writeDependency == true) {
                    writer.write("        <dependency org=\"" + valueGroupId
                            + "\" name=\"" + valueArtifactId
                            + "\" rev=\"" + valueVersion + "\"/>" + "\n");
                    valueGroupId = "";
                    valueArtifactId = "";
                    valueVersion = "";
                    writeDependency = false;
                }
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen: " + e);
        }
        in.close();
        // write footer
        writer.write("    </dependencies>" + "\n");
        writer.write("</ivy-module>" + "\n");
        writer.flush();
        writer.close();
        System.out.println("Die Datei " + ivyFilename + " wurde erfolgreich erstellt");
    }
    private static String getStringBeetween(String line, String startLine, String endLine) {
        String lineBetween = "";
        lineBetween = line.replace(startLine, "");
        lineBetween = lineBetween.replace(endLine, "");
        return lineBetween;
    }
}
