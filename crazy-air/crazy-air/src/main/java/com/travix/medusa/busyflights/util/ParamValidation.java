package com.travix.medusa.busyflights.util;

public class ParamValidation {

    /**
     * Method to check for null values and throw an exception if null
     * @param message message to be included if null
     * @param params list of params to be checked
     */
    public static void checkForNull(final String message, final Object ... params) {

        for (Object obj : params) {
            if (obj == null) {
                throw new IllegalArgumentException(message);
            }
        }
    }


}
