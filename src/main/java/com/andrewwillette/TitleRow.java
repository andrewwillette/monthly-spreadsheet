package com.andrewwillette;

import java.util.List;

/**
 * Represents a title row in monthly payments spreadsheet
 */
public class TitleRow {

    String columnA;
    String columnB;
    String columnC;
    String columnD;
    String columnE;
    String columnF;
    String columnG;
    String columnH;
    String columnI;
    String columnJ;
    String columnK;

    public TitleRow(List<Object> spreadsheetRow) {
        this.columnA = spreadsheetRow.get(0) != null ? (String)spreadsheetRow.get(0) : "";
        this.columnB = spreadsheetRow.get(0) != null ? (String)spreadsheetRow.get(1) : "";
        this.columnC = spreadsheetRow.get(0) != null ? (String)spreadsheetRow.get(2) : "";
        this.columnD = spreadsheetRow.get(0) != null ? (String)spreadsheetRow.get(3) : "";
        this.columnE = spreadsheetRow.get(0) != null ? (String)spreadsheetRow.get(4) : "";
        this.columnF = spreadsheetRow.get(0) != null ? (String)spreadsheetRow.get(5) : "";
        this.columnG = spreadsheetRow.get(0) != null ? (String)spreadsheetRow.get(6) : "";
        this.columnH = spreadsheetRow.get(0) != null ? (String)spreadsheetRow.get(7) : "";
        this.columnI = spreadsheetRow.get(0) != null ? (String)spreadsheetRow.get(8) : "";
        this.columnJ = spreadsheetRow.get(0) != null ? (String)spreadsheetRow.get(9) : "";
        this.columnK = spreadsheetRow.get(0) != null ? (String)spreadsheetRow.get(10) : "";

    }
}
