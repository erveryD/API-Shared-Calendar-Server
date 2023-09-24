package domain.apiserver.core.utils;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 날짜 유틸
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

    /**
     * 일자형식 : 년월일(yyyyMM)
     */
    public static final String DATE_FORMAT_YM = "yyyyMM";

    /**
     * 일자형식 : 년월일(yyyyMMdd)
     */
    public static final String DATE_FORMAT_YMD = "yyyyMMdd";

    /**
     * 일자형식 : 년월일시분초(yyyy-MM-dd)
     */
    public static final String DATE_FORMAT_YMD_DASH = "yyyy-MM-dd";

    /**
     * 일자형식 : 년월일시분초(yyyyMMddHHmmss)
     */
    public static final String DATE_FORMAT_YMS = "yyyyMMddHHmmss";

    /**
     * 일자형식 : 년월일시분초(yyyy-MM-dd HH:mm:ss)
     */
    public static final String DATE_FORMAT_YMS_DASH = "yyyy-MM-dd HH:mm:ss";

    /**
     * 일자형식 : 년월일시분초(yyyy.MM.dd HH:mm:ss)
     */
    public static final String DATE_FORMAT_YMS_COMMA = "yyyy.MM.dd HH:mm:ss";

    /**
     * 일자형식별 일자변환 오브젝트 보관소
     */
    private static final Map<String, DateTimeFormatter> formats = new HashMap<>();

    private static final LocalDate DATE_MAX =
            LocalDate.of(9999, 12, 31);

    private static final String DEFAULT_START_TIME = "0분";

    public static LocalDate kstNow() {
        return ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toLocalDate();
    }

    /**
     * 년월일(yyyyMM) 일자형식으로 실제 일자를 문자열로 변환하여 반환한다.
     *
     * @param date 문자열로 구성된 일자
     * @return 문자열로 변환된 일자
     */
    public static String toYmString(LocalDate date) {
        return toString(DATE_FORMAT_YM, date);
    }

    /**
     * 년월일(yyyyMMdd) 일자형식으로 실제 일자를 문자열로 변환하여 반환한다.
     *
     * @param date 문자열로 구성된 일자
     * @return 문자열로 변환된 일자
     */
    public static String toYmdString(LocalDate date) {
        return toString(DATE_FORMAT_YMD, date);
    }

    /**
     * 년월일(yyyy-MM-dd) 일자형식으로 실제 일자를 문자열로 변환하여 반환한다.
     *
     * @param date 문자열로 구성된 일자
     * @return 문자열로 변환된 일자
     */
    public static String toYmdDashString(LocalDate date) {
        return toString(DATE_FORMAT_YMD_DASH, date);
    }

    /**
     * 년월일(yyyyMMdd) 일자형식으로 문자열로 구성된 일자를 실제 일자로 변환하여 반환한다.
     *
     * @param date 문자열로 구성된 일자
     * @return 변환된 일자
     */
    public static LocalDate toDateYmd(String date) {
        return (LocalDate) toDate(DATE_FORMAT_YMD, date);
    }

    /**
     * 년월일(yyyyMMdd) 일자형식으로 일자를 변환하여 반환한다.
     *
     * @param date 일자
     * @return 일자형식으로 변환된 일자
     */
    public static LocalDate toDateYmd(LocalDate date) {
        return (LocalDate) toDate(DATE_FORMAT_YMD, date);
    }

    /**
     * 년월일(yyyyMMdd) 일자형식으로 일자를 변환하여 반환한다.
     *
     * @param date 일자
     * @return 일자형식으로 변환된 일자
     */
    public static LocalDate toDateYmd(LocalDate date, String format) {
        return (LocalDate) toDate(format, date);
    }

    /**
     * 년월일(yyyyMMdd) 일자형식으로 일자를 변환하여 반환한다.
     *
     * @param date 일자
     * @return 일자형식으로 변환된 일자
     */
    public static String toDateYmdString(LocalDate date, String format) {
        return toString(format, date);
    }

    /**
     * 년월일(yyyyMMdd) 일자형식으로 두 일자가 동한지 여부를 반환한다.
     *
     * @param date1 일자1
     * @param date2 일자2
     * @return 동일한 일자 여부
     */
    public static boolean equalsDateYmd(LocalDate date1, LocalDate date2) {
        return equalsDate(DATE_FORMAT_YMD, date1, date2);
    }

    /**
     * 년월일(yyyyMMdd) 일자형식으로 일자2 보다 일자1이 이후 일자인지 여부를 반환한다.
     *
     * @param date1 일자1
     * @param date2 일자2
     * @return 일자1이 이후 일자인지 여부
     */
    public static boolean afterDateYmd(LocalDate date1, LocalDate date2) {
        return afterDate(DATE_FORMAT_YMD, date1, date2);
    }

    /**
     * 년월일(yyyyMMdd) 일자형식으로 일자2 보다 일자1이 이전 일자인지 여부를 반환한다.
     *
     * @param date1 일자1
     * @param date2 일자2
     * @return 일자1이 이후 일자인지 여부
     */
    public static boolean beforeDateYmd(LocalDate date1, LocalDate date2) {
        return beforeDate(DATE_FORMAT_YMD, date1, date2);
    }

    /**
     * 년월일(yyyyMMdd) 일자형식으로 일자1, 일자2가 시작일자 또는 종료일자와 같거나 일자1, 일자2가 시작일자와 종료일자 사이에 포함되는지 여부를 반환한다.
     *
     * @param start 시작일자
     * @param end   종료일자
     * @param date1 일자1
     * @param date2 일자2
     * @return 시작일자와 종료일자 사이에 포함여부
     */
    public static boolean betweenDateYmd(LocalDate start, LocalDate end, LocalDate date1,
            LocalDate date2) {
        return betweenDate(DATE_FORMAT_YMD, start, end, date1, date2);
    }

    /**
     * 년월일(yyyyMMdd) 일자형식으로 일자가 시작일자 또는 종료일자와 같거나 일자가 시작일자와 종료일자 사이에 포함되는지 여부를 반환한다.
     *
     * @param start 시작일자
     * @param end   종료일자
     * @param date  일자
     * @return 시작일자와 종료일자 사이에 포함여부
     */
    public static boolean betweenDateYmd(LocalDate start, LocalDate end, LocalDate date) {
        return betweenDate(DATE_FORMAT_YMD, start, end, date);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 년월일시분초(yyyyMMddHHmmss) 일자형식으로 실제 일자를 문자열로 변환하여 반환한다.
     *
     * @param date 문자열로 구성된 일자
     * @return 문자열로 변환된 일자
     */
    public static String toYmsString(LocalDateTime date) {
        return toString(DATE_FORMAT_YMS, date);
    }

    /**
     * 년월일시분초(yyyy-MM-dd HH:mm:ss) 일자형식으로 실제 일자를 문자열로 변환하여 반환한다.
     *
     * @param date 문자열로 구성된 일자
     * @return 문자열로 변환된 일자
     */
    public static String toYmsDashString(LocalDateTime date) {
        return toString(DATE_FORMAT_YMS_DASH, date);
    }

    /**
     * 요청한 포맷으로 실제 일자를 문자열로 변환하여 반환한다.
     *
     * @param date   문자열로 구성된 일자
     * @param format 포맷
     * @return 문자열로 변환된 일자
     */
    public static String toYmsString(LocalDateTime date, String format) {
        return toString(format, date);
    }

    /**
     * 년월일시분초(yyyyMMddHHmmss) 일자형식으로 문자열로 구성된 일자를 실제 일자로 변환하여 반환한다.
     *
     * @param date 문자열로 구성된 일자
     * @return 변환된 일자
     */
    public static LocalDateTime toDateYms(String date) {
        return (LocalDateTime) toDateTime(DATE_FORMAT_YMS, date);
    }

    /**
     * HHMM 시간을 기준일과 조합하여 기준일시를 리턴한다.
     *
     * @param time      HHMM 형태의 시간정보
     * @param localDate 기준일자
     * @return HHMM 입력시간으로 기준일시 리턴
     */
    public static LocalDateTime timeToLocalDateTime(String time, LocalDate localDate) {
        String hour = time.split(":")[0];
        String minute = time.split(":")[1];
        LocalTime localtime = LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minute));

        return localDate.atTime(localtime);
    }

    /**
     * 년월일시분초(yyyyMMddHHmmss) 일자형식으로 일자를 변환하여 반환한다.
     *
     * @param date 일자
     * @return 일자형식으로 변환된 일자
     */
    public static LocalDateTime toDateYms(LocalDateTime date) {
        return (LocalDateTime) toDate(DATE_FORMAT_YMS, date);
    }

    /**
     * 년월일시분초(yyyyMMddHHmmss) 일자형식으로 일자를 변환하여 반환한다.
     *
     * @param date   일자
     * @param format 포맷
     * @return 일자형식으로 변환된 일자
     */
    public static LocalDateTime toDateYms(LocalDateTime date, String format) {
        return (LocalDateTime) toDate(format, date);
    }

    /**
     * 년월일시분초(yyyy.MM.dd HH:mm:ss) 형식 문자를 LocalDateTime 으로 변환하여 반환한다.
     *
     * @param date 일자
     * @return 일자형식으로 변환된 일자
     */
    public static LocalDateTime toDateTimeYmsComma(String date) {
        return (LocalDateTime) toDateTime(DATE_FORMAT_YMS_COMMA, date);
    }


    /**
     * 년월일시분초(yyyyMMddHHmmss) 일자형식으로 두 일자가 동한지 여부를 반환한다.
     *
     * @param date1 일자1
     * @param date2 일자2
     * @return 동일한 일자 여부
     */
    public static boolean equalsDateYms(LocalDateTime date1, LocalDateTime date2) {
        return equalsDate(DATE_FORMAT_YMS, date1, date2);
    }

    /**
     * 년월일시분초(yyyyMMddHHmmss) 일자형식으로 일자2 보다 일자1이 이후 일자인지 여부를 반환한다.
     *
     * @param date1 일자1
     * @param date2 일자2
     * @return 일자1이 이후 일자인지 여부
     */
    public static boolean afterDateYms(LocalDateTime date1, LocalDateTime date2) {
        return afterDate(DATE_FORMAT_YMS, date1, date2);
    }

    /**
     * 년월일시분초(yyyyMMddHHmmss) 일자형식으로 일자2 보다 일자1이 이전 일자인지 여부를 반환한다.
     *
     * @param date1 일자1
     * @param date2 일자2
     * @return 일자1이 이후 일자인지 여부
     */
    public static boolean beforeDateYms(LocalDateTime date1, LocalDateTime date2) {
        return beforeDate(DATE_FORMAT_YMS, date1, date2);
    }

    /**
     * 년월일시분초(yyyyMMddHHmmss) 일자형식으로 일자1, 일자2가 시작일자 또는 종료일자와 같거나 일자1, 일자2가 시작일자와 종료일자 사이에 포함되는지 여부를
     * 반환한다.
     *
     * @param start 시작일자
     * @param end   종료일자
     * @param date1 일자1
     * @param date2 일자2
     * @return 시작일자와 종료일자 사이에 포함여부
     */
    public static boolean betweenDateYms(LocalDateTime start, LocalDateTime end,
            LocalDateTime date1, LocalDateTime date2) {
        return betweenDate(DATE_FORMAT_YMS, start, end, date1, date2);
    }

    /**
     * 년월일시분초(yyyyMMddHHmmss) 일자형식으로 일자가 시작일자 또는 종료일자와 같거나 일자가 시작일자와 종료일자 사이에 포함되는지 여부를 반환한다.
     *
     * @param start 시작일자
     * @param end   종료일자
     * @param date  일자
     * @return 시작일자와 종료일자 사이에 포함여부
     */
    public static boolean betweenDateYms(LocalDateTime start, LocalDateTime end,
            LocalDateTime date) {
        return betweenDate(DATE_FORMAT_YMS, start, end, date);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 주어진 일자형식으로 실제 일자를 문자열로 변환하여 반환한다.
     *
     * @param format 일자형식
     * @param date   문자열로 구성된 일자
     * @return 문자열로 변환된 일자
     */
    public static String toString(String format, TemporalAccessor date) {
        if (!formats.containsKey(format)) {
            formats.put(format, DateTimeFormatter.ofPattern(format));
        }

        return formats.get(format).format(date);
    }

    /**
     * 주어진 일자형식으로 문자열로 구성된 일자를 실제 일자로 변환하여 반환한다.
     *
     * @param date 문자열로 구성된 일자
     * @return 변환된 일자
     */
    public static TemporalAccessor toDate(String format, String date) {
        TemporalAccessor toDate = null;

        if (!formats.containsKey(format)) {
            formats.put(format, DateTimeFormatter.ofPattern(format));
        }

        try {
            toDate = LocalDate.parse(date, formats.get(format));
        } catch (Throwable e) {
            throw new IllegalArgumentException(
                    String.format("주어진 형식(%s)에 맞지 않는 일자(%s) 입니다.", format, date), e);
        }

        return toDate;
    }

    /**
     * 주어진 일자형식으로 문자열로 구성된 일자를 실제 일자로 변환하여 반환한다.
     *
     * @param date 문자열로 구성된 일자
     * @return 변환된 일자
     */
    public static TemporalAccessor toDateTime(String format, String date) {
        TemporalAccessor toDateTime = null;

        if (!formats.containsKey(format)) {
            formats.put(format, DateTimeFormatter.ofPattern(format));
        }

        try {
            toDateTime = LocalDateTime.parse(date, formats.get(format));
        } catch (Throwable e) {
            throw new IllegalArgumentException(
                    String.format("주어진 형식(%s)에 맞지 않는 일자(%s) 입니다.", format, date), e);
        }

        return toDateTime;
    }

    /**
     * 주어진 일자형식으로 일자를 변환하여 반환한다.
     *
     * @param date 일자
     * @return 일자형식으로 변환된 일자
     */
    public static TemporalAccessor toDate(String format, TemporalAccessor date) {
        TemporalAccessor toDate = null;

        if (!formats.containsKey(format)) {
            formats.put(format, DateTimeFormatter.ofPattern(format));
        }

        try {
            toDate = LocalDate.parse(formats.get(format).format(date), formats.get(format));
        } catch (Throwable e) {
            throw new IllegalArgumentException(
                    String.format("주어진 형식(%s)에 맞지 않는 일자(%s) 입니다.", format, date), e);
        }

        return toDate;
    }

    public static boolean isEqualOrAfter(LocalDate afterDate, LocalDate date) {
        return afterDate.isEqual(date) || afterDate.isAfter(date);
    }

    /**
     * 주어진 일자형식으로 두 일자가 동한지 여부를 반환한다.
     *
     * @param format 일자형식
     * @param date1  일자1
     * @param date2  일자2
     * @return 동일한 일자 여부
     */
    public static boolean equalsDate(String format, TemporalAccessor date1,
            TemporalAccessor date2) {
        boolean isEqual = false;

        final TemporalAccessor tDate1 = toDate(format, date1);
        final TemporalAccessor tDate2 = toDate(format, date2);

        if (tDate1 instanceof LocalDate) {
            isEqual = ((LocalDate) tDate1).isEqual((LocalDate) tDate2);
        } else {
            if (tDate1 instanceof LocalDateTime) {
                isEqual = ((LocalDateTime) tDate1).isEqual((LocalDateTime) tDate2);
            }
        }

        return isEqual;
    }

    /**
     * 일자2 보다 일자1이 이후 일자인지 여부를 반환한다.
     *
     * @param format 일자형식
     * @param date1  일자1
     * @param date2  일자2
     * @return 일자1이 이후 일자인지 여부
     */
    public static boolean afterDate(String format, TemporalAccessor date1, TemporalAccessor date2) {
        boolean isAfter = false;

        final TemporalAccessor tDate1 = toDate(format, date1);
        final TemporalAccessor tDate2 = toDate(format, date2);

        if (tDate1 instanceof LocalDate) {
            isAfter = ((LocalDate) tDate1).isAfter((LocalDate) tDate2);
        } else {
            if (tDate1 instanceof LocalDateTime) {
                isAfter = ((LocalDateTime) tDate1).isAfter((LocalDateTime) tDate2);
            }
        }

        return isAfter;
    }

    /**
     * 일자2 보다 일자1이 이전 일자인지 여부를 반환한다.
     *
     * @param format 일자형식
     * @param date1  일자1
     * @param date2  일자2
     * @return 일자1이 이후 일자인지 여부
     */
    public static boolean beforeDate(String format, TemporalAccessor date1,
            TemporalAccessor date2) {
        boolean isBefore = false;

        final TemporalAccessor tDate1 = toDate(format, date1);
        final TemporalAccessor tDate2 = toDate(format, date2);

        if (tDate1 instanceof LocalDate) {
            isBefore = ((LocalDate) tDate1).isBefore((LocalDate) tDate2);
        } else {
            if (tDate1 instanceof LocalDateTime) {
                isBefore = ((LocalDateTime) tDate1).isBefore((LocalDateTime) tDate2);
            }
        }

        return isBefore;
    }

    /**
     * 주어진 일자형식으로 일자1, 일자2가 시작일자 또는 종료일자와 같거나 일자1, 일자2가 시작일자와 종료일자 사이에 포함되는지 여부를 반환한다.
     *
     * @param format 일자형식
     * @param start  시작일자
     * @param end    종료일자
     * @param date1  일자1
     * @param date2  일자2
     * @return 시작일자와 종료일자 사이에 포함여부
     */
    public static boolean betweenDate(String format, TemporalAccessor start, TemporalAccessor end,
            TemporalAccessor date1, TemporalAccessor date2) {
        return betweenDate(format, start, end, date1) && betweenDate(format, start, end, date2);
    }

    /**
     * 주어진 일자형식으로 일자가 시작일자 또는 종료일자와 같거나 일자가 시작일자와 종료일자 사이에 포함되는지 여부를 반환한다.
     *
     * @param format 일자형식
     * @param start  시작일자
     * @param end    종료일자
     * @param date   일자
     * @return 시작일자와 종료일자 사이에 포함여부
     */
    public static boolean betweenDate(String format, TemporalAccessor start, TemporalAccessor end,
            TemporalAccessor date) {
        boolean isBetween = false;

        final TemporalAccessor sDate = toDate(format, start);
        final TemporalAccessor eDate = toDate(format, end);
        final TemporalAccessor tDate = toDate(format, date);

        // before : 이후, after : 이전
        if (tDate instanceof LocalDate) {
            isBetween = (((LocalDate) tDate).isEqual((LocalDate) sDate)
                    || ((LocalDate) tDate).isEqual((LocalDate) eDate) || !(
                    ((LocalDate) tDate).isBefore((LocalDate) sDate) || ((LocalDate) tDate).isAfter(
                            (LocalDate) eDate)));
        } else {
            if (tDate instanceof LocalDateTime) {
                isBetween = (((LocalDateTime) tDate).isEqual((LocalDateTime) sDate)
                        || ((LocalDateTime) tDate).isEqual((LocalDateTime) eDate) || !(
                        ((LocalDateTime) tDate).isBefore((LocalDateTime) sDate)
                                || ((LocalDateTime) tDate).isAfter((LocalDateTime) eDate)));
            }
        }

        return isBetween;
    }

    /**
     * 밀리세컨드 -> 일시분초밀리세컨드로 변환하여 표기
     *
     * @param ms 밀리세컨드
     * @return 일시분초밀리세컨드
     */
    public static String toDdhhmmssms(long ms) {
        long days = ms / (24 * 60 * 60 * 1000);
        long hours = ms / (60 * 60 * 1000) % 24;
        long minutes = ms / (60 * 1000) % 60;
        long seconds = ms / 1000 % 60;

        StringBuffer sb = new StringBuffer();
        sb.append(days > 0 ? days + " days " : "");
        sb.append(hours > 0 ? hours + " hours " : "");
        sb.append(minutes > 0 ? minutes + " minutes " : "");
        sb.append(seconds > 0 ? seconds + " seconds " : "");

        if (sb.length() == 0) {
            sb.append(ms).append("ms");
        }

        return sb.toString();
    }

    /**
     * 듀레이션을 N분 또는 N시간 N분 으로 변환
     *
     * @param duration 듀레이션
     * @return 스트링타입의 변환된 시간(N분 또는 N시간 N분)
     */
    public static String durationToTime(Duration duration) {
        if (duration.toHours() > 0) {
            return String.format("%d시간 %d분",
                    duration.toHours(), duration.toMinutesPart());
        } else {
            return String.format("%d분", duration.toMinutesPart());
        }
    }

    /**
     * 기본 정의된 시작 시간 조회
     *
     * @return 기본 정의된 시작 시간 반환
     */
    public static String getDefaultStartTime() {
        return DEFAULT_START_TIME;
    }

    /**
     * LocaleDateTime을 LocalDate로 변경하는 메소드 (널허용)
     *
     * @param localDateTime 변환대상 LocalDateTIme
     * @return LocalDate 형태 반환
     */
    public static LocalDate toLocalDate(LocalDateTime localDateTime) {
        return Optional.ofNullable(localDateTime)
                .map(LocalDateTime::toLocalDate)
                .orElseGet(() -> null);
    }

    /**
     * LocaleDateTime to YearMonth
     *
     * @param dateTime 일시
     * @return 년월
     */
    public static YearMonth toYm(LocalDateTime dateTime) {
        return YearMonth.of(dateTime.getYear(), dateTime.getMonth());
    }

    /**
     * LocaleDateTime to YearMonth
     *
     * @param dateTime 일시
     * @return 년월
     */
    public static YearMonth toYm(LocalDate dateTime) {
        return YearMonth.of(dateTime.getYear(), dateTime.getMonth());
    }

    /**
     * N월 1일의 00:00초로 반환한다.
     *
     * @param ym 연월
     * @return 시작 일시
     */
    public static LocalDateTime toStartDt(YearMonth ym) {
        return LocalDateTime.of(ym.atDay(1), LocalTime.MIN);
    }

    /**
     * N월 마지막 일자의 23:59:59.999999999초로 반환한다.
     *
     * @param ym 연월
     * @return 마지막 일시
     */
    public static LocalDateTime toEndDt(YearMonth ym) {
        return LocalDateTime.of(ym.atEndOfMonth(), LocalTime.MAX);
    }

    /**
     * N월 1일을 반환한다.
     *
     * @param ym 연월
     * @return N월 시작일
     */
    public static LocalDate toStartDate(YearMonth ym) {
        return ym.atDay(1);
    }

    /**
     * N월 마지막 일을 반환한다.
     *
     * @param ym 연월
     * @return N월 마지막일
     */
    public static LocalDate toEndDate(YearMonth ym) {
        return ym.atEndOfMonth();
    }

    /**
     * 두 LOCALDATE 사이의 DAY차이 정수 반환.
     *
     * @param start
     * @param end
     * @return 시작일자와 종료일자의 DAY차이 정수
     */
    public static long getBetweenDay(LocalDate start, LocalDate end) {
        return Duration.between(start.atStartOfDay(), end.atStartOfDay()).toDays();
    }

}