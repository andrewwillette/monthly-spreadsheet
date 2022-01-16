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
    private final double extraPaidByRoommate;
    private final String extraPaidByRoommateDescription;

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
        this.extraPaidByRoommate = parseValueAsDouble(spreadsheetRow, 8);
        this.extraPaidByRoommateDescription = parseValueAsString(spreadsheetRow, 9);
    }

    /**
     * What we came for.
     * @return what's owed
     */
    public double getRoomatesPayment() {
        return rent/2
                + electricity/2
                + groceries/2
                + extraPaidByMe/2
                - internet/2
                - extraPaidByRoommate /2;
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
                ", extraPaidByRoommate=" + extraPaidByRoommate +
                ", extraPaidByRoommateDescription=" + extraPaidByRoommateDescription +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentRow that = (PaymentRow) o;

        if (Double.compare(that.creditCard, creditCard) != 0) return false;
        if (Double.compare(that.rent, rent) != 0) return false;
        if (Double.compare(that.electricity, electricity) != 0) return false;
        if (Double.compare(that.internet, internet) != 0) return false;
        if (Double.compare(that.groceries, groceries) != 0) return false;
        if (Double.compare(that.extraPaidByMe, extraPaidByMe) != 0) return false;
        if (Double.compare(that.extraPaidByRoommate, extraPaidByRoommate) != 0) return false;
        if (!date.equals(that.date)) return false;
        if (!extraPaidByMeDescription.equals(that.extraPaidByMeDescription)) return false;
        return extraPaidByRoommateDescription.equals(that.extraPaidByRoommateDescription);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = date.hashCode();
        temp = Double.doubleToLongBits(creditCard);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(rent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(electricity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(internet);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(groceries);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(extraPaidByMe);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + extraPaidByMeDescription.hashCode();
        temp = Double.doubleToLongBits(extraPaidByRoommate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + extraPaidByRoommateDescription.hashCode();
        return result;
    }
}
