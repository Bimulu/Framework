package nu.neonet.framework.utilities.numeral;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberUtils {

    private static final NumberFormat numberFormat = NumberFormat.getInstance(new Locale("da", "DK"));

    public static int randomInteger(int input) {
        int min = 1;
        int max = input;

        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static String format(long val) {
        return numberFormat.format(val);
    }

    public static String format(int val) {
        return numberFormat.format(val);
    }

    public static String format(double val) {
        return numberFormat.format(val);
    }

    public static double percentage(double obtained, double total) {
        return obtained * 100 / total;
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
}
