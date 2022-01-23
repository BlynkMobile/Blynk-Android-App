package net.danlew.android.joda;

import android.content.Context;
import android.content.res.Resources;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Hours;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.Minutes;
import org.joda.time.ReadableDuration;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;
import org.joda.time.Seconds;
import org.joda.time.Weeks;
import org.joda.time.Years;

public class DateUtils {
    private static final DateTime EPOCH = new DateTime(0, DateTimeZone.UTC);
    public static final int FORMAT_ABBREV_ALL = 524288;
    public static final int FORMAT_ABBREV_MONTH = 65536;
    public static final int FORMAT_ABBREV_RELATIVE = 262144;
    public static final int FORMAT_ABBREV_TIME = 16384;
    public static final int FORMAT_ABBREV_WEEKDAY = 32768;
    public static final int FORMAT_NO_MIDNIGHT = 2048;
    public static final int FORMAT_NO_MONTH_DAY = 32;
    public static final int FORMAT_NO_NOON = 512;
    public static final int FORMAT_NO_YEAR = 8;
    public static final int FORMAT_NUMERIC_DATE = 131072;
    public static final int FORMAT_SHOW_DATE = 16;
    public static final int FORMAT_SHOW_TIME = 1;
    public static final int FORMAT_SHOW_WEEKDAY = 2;
    public static final int FORMAT_SHOW_YEAR = 4;
    private static final int FORMAT_UTC = 8192;

    public static String formatDateRange(Context context, ReadablePartial readablePartial, ReadablePartial readablePartial2, int i) {
        return formatDateRange(context, toMillis(readablePartial), toMillis(readablePartial2), i);
    }

    public static String formatDateTime(Context context, ReadablePartial readablePartial, int i) {
        return android.text.format.DateUtils.formatDateTime(context, toMillis(readablePartial), i | FORMAT_UTC);
    }

    public static CharSequence formatDuration(Context context, ReadableDuration readableDuration) {
        Resources resources = context.getResources();
        Duration duration = readableDuration.toDuration();
        int standardHours = (int) duration.getStandardHours();
        if (standardHours != 0) {
            return resources.getQuantityString(C6501R.plurals.joda_time_android_duration_hours, standardHours, new Object[]{Integer.valueOf(standardHours)});
        }
        int standardMinutes = (int) duration.getStandardMinutes();
        if (standardMinutes != 0) {
            return resources.getQuantityString(C6501R.plurals.joda_time_android_duration_minutes, standardMinutes, new Object[]{Integer.valueOf(standardMinutes)});
        }
        int standardSeconds = (int) duration.getStandardSeconds();
        return resources.getQuantityString(C6501R.plurals.joda_time_android_duration_seconds, standardSeconds, new Object[]{Integer.valueOf(standardSeconds)});
    }

    public static String formatElapsedTime(ReadableDuration readableDuration) {
        return formatElapsedTime((StringBuilder) null, readableDuration);
    }

    public static CharSequence getRelativeDateTimeString(Context context, ReadablePartial readablePartial, ReadablePeriod readablePeriod, int i) {
        if (readablePartial.isSupported(DateTimeFieldType.hourOfDay()) && readablePartial.isSupported(DateTimeFieldType.minuteOfHour())) {
            return getRelativeDateTimeString(context, (ReadableInstant) readablePartial.toDateTime(DateTime.now()), readablePeriod, i);
        }
        throw new IllegalArgumentException("getRelativeDateTimeString() must be passed a ReadablePartial that supports time, otherwise it makes no sense");
    }

    public static CharSequence getRelativeTimeSpanString(Context context, ReadablePartial readablePartial) {
        return getRelativeTimeSpanString(context, (ReadableInstant) readablePartial.toDateTime(DateTime.now()));
    }

    public static boolean isToday(ReadablePartial readablePartial) {
        if (!readablePartial.isSupported(DateTimeFieldType.dayOfMonth()) || !readablePartial.isSupported(DateTimeFieldType.monthOfYear()) || !readablePartial.isSupported(DateTimeFieldType.year())) {
            throw new IllegalArgumentException("isToday() must be passed a ReadablePartial that supports day of month, month of year and year.");
        }
        return LocalDate.now().compareTo((ReadablePartial) readablePartial instanceof LocalDate ? (LocalDate) readablePartial : new LocalDate((Object) readablePartial)) == 0;
    }

    private static long toMillis(ReadablePartial readablePartial) {
        return readablePartial.toDateTime(EPOCH).getMillis();
    }

    public static String formatDateRange(Context context, ReadableInstant readableInstant, ReadableInstant readableInstant2, int i) {
        return formatDateRange(context, toMillis(readableInstant), toMillis(readableInstant2), i);
    }

    public static String formatDateTime(Context context, ReadableInstant readableInstant, int i) {
        return android.text.format.DateUtils.formatDateTime(context, toMillis(readableInstant), i | FORMAT_UTC);
    }

    public static String formatElapsedTime(StringBuilder sb, ReadableDuration readableDuration) {
        return android.text.format.DateUtils.formatElapsedTime(sb, (long) readableDuration.toDuration().toStandardSeconds().getSeconds());
    }

    public static CharSequence getRelativeTimeSpanString(Context context, ReadableInstant readableInstant) {
        return getRelativeTimeSpanString(context, readableInstant, 65556);
    }

    private static long toMillis(ReadableInstant readableInstant) {
        return (readableInstant instanceof DateTime ? (DateTime) readableInstant : new DateTime((Object) readableInstant)).withZoneRetainFields(DateTimeZone.UTC).getMillis();
    }

    private static String formatDateRange(Context context, long j, long j2, int i) {
        if (j != j2) {
            j2 += 1000;
        }
        return android.text.format.DateUtils.formatDateRange(context, j, j2, i | FORMAT_UTC);
    }

    public static CharSequence getRelativeTimeSpanString(Context context, ReadablePartial readablePartial, int i) {
        return getRelativeTimeSpanString(context, (ReadableInstant) readablePartial.toDateTime(DateTime.now()), i);
    }

    public static CharSequence getRelativeTimeSpanString(Context context, ReadableInstant readableInstant, int i) {
        Interval interval;
        long j;
        int i2;
        boolean z = (786432 & i) != 0;
        DateTime withMillisOfSecond = DateTime.now(readableInstant.getZone()).withMillisOfSecond(0);
        DateTime withMillisOfSecond2 = new DateTime((Object) readableInstant).withMillisOfSecond(0);
        boolean z2 = !withMillisOfSecond.isBefore((ReadableInstant) withMillisOfSecond2);
        if (!z2) {
            interval = new Interval((ReadableInstant) withMillisOfSecond, (ReadableInstant) withMillisOfSecond2);
        }
        if (Minutes.minutesIn(interval).isLessThan(Minutes.ONE)) {
            j = (long) Seconds.secondsIn(interval).getSeconds();
            if (z2) {
                if (z) {
                    i2 = C6501R.plurals.joda_time_android_abbrev_num_seconds_ago;
                } else {
                    i2 = C6501R.plurals.joda_time_android_num_seconds_ago;
                }
            } else if (z) {
                i2 = C6501R.plurals.joda_time_android_abbrev_in_num_seconds;
            } else {
                i2 = C6501R.plurals.joda_time_android_in_num_seconds;
            }
        } else if (Hours.hoursIn(interval).isLessThan(Hours.ONE)) {
            j = (long) Minutes.minutesIn(interval).getMinutes();
            if (z2) {
                if (z) {
                    i2 = C6501R.plurals.joda_time_android_abbrev_num_minutes_ago;
                } else {
                    i2 = C6501R.plurals.joda_time_android_num_minutes_ago;
                }
            } else if (z) {
                i2 = C6501R.plurals.joda_time_android_abbrev_in_num_minutes;
            } else {
                i2 = C6501R.plurals.joda_time_android_in_num_minutes;
            }
        } else if (Days.daysIn(interval).isLessThan(Days.ONE)) {
            j = (long) Hours.hoursIn(interval).getHours();
            if (z2) {
                if (z) {
                    i2 = C6501R.plurals.joda_time_android_abbrev_num_hours_ago;
                } else {
                    i2 = C6501R.plurals.joda_time_android_num_hours_ago;
                }
            } else if (z) {
                i2 = C6501R.plurals.joda_time_android_abbrev_in_num_hours;
            } else {
                i2 = C6501R.plurals.joda_time_android_in_num_hours;
            }
        } else if (!Weeks.weeksIn(interval).isLessThan(Weeks.ONE)) {
            return formatDateRange(context, readableInstant, readableInstant, i);
        } else {
            j = (long) Days.daysIn(interval).getDays();
            if (z2) {
                if (z) {
                    i2 = C6501R.plurals.joda_time_android_abbrev_num_days_ago;
                } else {
                    i2 = C6501R.plurals.joda_time_android_num_days_ago;
                }
            } else if (z) {
                i2 = C6501R.plurals.joda_time_android_abbrev_in_num_days;
            } else {
                i2 = C6501R.plurals.joda_time_android_in_num_days;
            }
        }
        return String.format(context.getResources().getQuantityString(i2, (int) j), new Object[]{Long.valueOf(j)});
    }

    public static CharSequence getRelativeDateTimeString(Context context, ReadableInstant readableInstant, ReadablePeriod readablePeriod, int i) {
        Duration duration;
        Duration duration2;
        Resources resources = context.getResources();
        DateTime withMillisOfSecond = DateTime.now(readableInstant.getZone()).withMillisOfSecond(0);
        DateTime withMillisOfSecond2 = new DateTime((Object) readableInstant).withMillisOfSecond(0);
        boolean z = !withMillisOfSecond.isBefore((ReadableInstant) withMillisOfSecond2);
        if (!z) {
            duration = new Duration((ReadableInstant) withMillisOfSecond, (ReadableInstant) withMillisOfSecond2);
        }
        Duration durationTo = Days.ONE.toPeriod().toDurationTo(withMillisOfSecond2);
        if (readablePeriod != null) {
            if (z) {
                duration2 = readablePeriod.toPeriod().toDurationTo(withMillisOfSecond);
            } else {
                duration2 = readablePeriod.toPeriod().toDurationFrom(withMillisOfSecond);
            }
            Duration durationTo2 = Weeks.ONE.toPeriod().toDurationTo(withMillisOfSecond2);
            if (duration2.isLongerThan(durationTo2)) {
                durationTo = durationTo2;
            } else if (!duration2.isShorterThan(durationTo)) {
                durationTo = duration2;
            }
        }
        String formatDateRange = formatDateRange(context, readableInstant, readableInstant, 1);
        if (!duration.isLongerThan(durationTo)) {
            return resources.getString(C6501R.string.joda_time_android_relative_time, new Object[]{getRelativeTimeSpanString(context, readableInstant, i), formatDateRange});
        }
        return resources.getString(C6501R.string.joda_time_android_date_time, new Object[]{getRelativeTimeSpanString(context, readableInstant, false), formatDateRange});
    }

    public static boolean isToday(ReadableInstant readableInstant) {
        return LocalDate.now().compareTo((ReadablePartial) new LocalDate((Object) readableInstant)) == 0;
    }

    public static CharSequence getRelativeTimeSpanString(Context context, ReadablePartial readablePartial, boolean z) {
        return getRelativeTimeSpanString(context, (ReadableInstant) readablePartial.toDateTime(DateTime.now()), z);
    }

    public static CharSequence getRelativeTimeSpanString(Context context, ReadableInstant readableInstant, boolean z) {
        String str;
        int i;
        LocalDate now = LocalDate.now();
        LocalDate localDate = new LocalDate((Object) readableInstant);
        if (Days.daysBetween((ReadablePartial) now, (ReadablePartial) localDate).getDays() == 0) {
            str = formatDateRange(context, readableInstant, readableInstant, 1);
            i = C6501R.string.joda_time_android_preposition_for_time;
        } else if (Years.yearsBetween((ReadablePartial) now, (ReadablePartial) localDate).getYears() != 0) {
            str = formatDateRange(context, readableInstant, readableInstant, 131092);
            i = C6501R.string.joda_time_android_preposition_for_date;
        } else {
            str = formatDateRange(context, readableInstant, readableInstant, 65552);
            i = C6501R.string.joda_time_android_preposition_for_date;
        }
        if (!z) {
            return str;
        }
        return context.getString(i, new Object[]{str});
    }
}
