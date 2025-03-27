package nu.neonet.framework.utilities.time.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date date(long date) {
        return new Date(date);
    }

    public static String formatDate(Date date, String pattern) {
        if (pattern == null) pattern = "MM/dd/yyyy";

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        return dateFormat.format(date);
    }

    public static String formatDate(long date, String pattern) {
        if (pattern == null) pattern = "MM/dd/yyyy";

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        return dateFormat.format(date(date));
    }
}
