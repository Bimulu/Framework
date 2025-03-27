package nu.neonet.framework.utilities.time;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Time {


    public static String getRemainingTimeTillNextReward(Date current) {

        long millis = TimeUnit.SECONDS.toMillis(getDateDiff(current));

        long days = TimeUnit.MILLISECONDS.toDays(millis);

        long hours = TimeUnit.MILLISECONDS.toHours(millis)
                - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millis));

        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis));

        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis));

        String time = String.format("§6%02d §7%s, §6%02d §7%s, §6%02d §7%s og §6%02d §7%s",

                days,
                "dage",

                hours,
                "timer",

                minutes,
                "minutter",

                seconds,
                "sekunder");

        time = time.replace("§", "&");

        if (days <= 0) {
            time = time.replace("00 &7dage, ", "");
        } else if (days < 10) {
            time = time.replaceFirst("0", "");
            if (days == 1) {
                time = time.replace("dage", "dag");
            }
        }
        if (hours <= 0) {
            time = time.replace("00 &7timer, ", "");
        } else if (hours < 10) {
            time = time.replaceFirst("0", "");
            if (hours == 1) {
                time = time.replace("timer", "time");
            }
        }
        if (minutes <= 0) {
            time = time.replace("00 &7minutter ", "");
        } else if (minutes < 10) {
            time = time.replaceFirst("0", "");
            if (minutes == 1) {
                time = time.replace("minutter", "minut");
            }
        }
        if (seconds <= 0) {
            time = time.replace("og &600 &7sekunder", "");
        } else if (seconds < 10) {
            time = time.replaceFirst("0", "");
            if (seconds == 1) {
                time = time.replace("sekunder", "sekund");
            }
        }

        return time.replace("&", "§");
    }

    public static long getDateDiff(Date date) {
        long diffInMillies = date.getTime() - new Date().getTime();
        return TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }


}
