package com.andrewwillette;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Represents a payments row in monthly payments spreadsheet
 */
public class PaymentRow extends SpreadsheetRow {

    private final Date date;
    private final double creditCard;
    private final double rent;
    private final double electricity;
    private final double internet;
    private final double groceries;
    private final double extraPaidByMe;
    private final String extraPaidByMeDescription;
    private final double extraPaidByRoomate;
    private final String extraPaidByRoomateDescription;

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Indexes for creation received by manually reading spreadsheet online.
     * @param spreadsheetRow
     */
    public PaymentRow(List<Object> spreadsheetRow) {
        this.date = parseValueAsDate(spreadsheetRow, 0);
        this.creditCard = parseValueAsDouble(spreadsheetRow, 1);
        this.rent = parseValueAsDouble(spreadsheetRow, 2);
        this.electricity = parseValueAsDouble(spreadsheetRow, 3);
        this.internet = parseValueAsDouble(spreadsheetRow, 4);
        this.groceries = parseValueAsDouble(spreadsheetRow, 5);
        this.extraPaidByMe = parseValueAsDouble(spreadsheetRow, 6);
        this.extraPaidByMeDescription = parseValueAsString(spreadsheetRow, 7);
        this.extraPaidByRoomate = parseValueAsDouble(spreadsheetRow, 8);
        this.extraPaidByRoomateDescription = parseValueAsString(spreadsheetRow, 9);
    }

    public double getRoomatesPayment() {
        return rent/2 + electricity/2 + groceries/2 + extraPaidByMe /2 - internet/2;
    }

    public Date getDate() {
        return date;
    }

    public double getCreditCard() {
        return creditCard;
    }

    public double getRent() {
        return this.rent;
    }

    public double getElectricity() {
        return this.electricity;
    }

    public double getGroceries() {
        return this.groceries;
    }

    @Override
    public String toString() {
        return "PaymentRow{" +
                "date=" + DATE_FORMAT.format(date) +
                ", rent=" + rent +
                ", creditCard=" + creditCard +
                ", electricity=" + electricity +
                ", internet=" + internet +
                ", groceries=" + groceries +
                ", extraPaidByMe=" + extraPaidByMe +
                ", extraPaidByMeDescription=" + extraPaidByMeDescription +
                ", extraPaidByRoomate=" + extraPaidByRoomate +
                ", extraPaidByRoomateDescription=" + extraPaidByRoomateDescription +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentRow that = (PaymentRow) o;
        return Double.compare(that.rent, rent) == 0
                && Double.compare(that.creditCard, creditCard) == 0
                && Double.compare(that.electricity, electricity) == 0
                && Double.compare(that.internet, internet) == 0
                && date.equals(that.date)
                && Objects.equals(DATE_FORMAT, that.DATE_FORMAT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, rent, creditCard, electricity, internet, DATE_FORMAT);
    }
}
