package com.andrewwillette;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * exposes some utility methods for interacting with google api spreadsheet rows
 */
public abstract class SpreadsheetRow {

    double parseValueAsDouble(List<Object> row, Integer index) {
        try {
            return Double.parseDouble((String) row.get(index));
        } catch (Exception ex) {
            return 0;
        }
    }

    Date parseValueAsDate(List<Object> row, Integer index) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse((String)row.get(index));
        } catch (Exception ex) {
            return null;
        }
    }

    Integer parseValueAsInteger(List<Object> row, Integer index) {
        try {
            return Integer.parseInt((String) row.get(index));
        } catch (Exception ex) {
            return 0;
        }
    }

    String parseValueAsString(List<Object> row, Integer index) {
        try {
            return (String) row.get(index);
        } catch (Exception ex) {
            return "";
        }
    }

}
