package com.travix.medusa.busyflights.util;

public class NumberUtil {

    /**
     * Method to calculate the final amount after tax and discount applies
     * @param amount base amount before tax/discount
     * @param tax to be applied
     * @param discount discount to be applied
     * @return
     */
    public static double calculateFinalAmount(double amount, final Double tax, final Double discount) {
        if (amount != 0) {
            if (discount != null && discount != 0) {
                amount = amount - (amount * (discount / 100));
            }
            if (tax != null && tax != 0) {
                amount = amount + (amount * (tax / 100));
            }
        }
        return amount;
    }
}
