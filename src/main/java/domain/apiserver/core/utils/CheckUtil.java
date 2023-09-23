package domain.apiserver.core.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 값 검사 유틸
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CheckUtil {

    private static final int ZERO = 0;

    /**
     * NULL 또는 공백인지 체크
     *
     * @param value 값
     * @return NULL 또는 공백이면 참
     */
    public static boolean isNullOrEmpty(String value) {
        return (null == value || value.trim().isEmpty());
    }

    /**
     * NULL 또는 공백이 아닌지 체크
     *
     * @param value 값
     * @return NULL 또는 공백이 아니면 참
     */
    public static boolean isNotNullOrNotEmpty(String value) {
        return !isNullOrEmpty(value);
    }

    /**
     * NULL 또는 공백이면 기본값 반환
     *
     * @param value        값
     * @param defaultValue 기본값
     * @return NULL 또는 공백이면 기본값
     */
    public static String nvl(String value, String defaultValue) {
        return (isNullOrEmpty(value) ? defaultValue : value);
    }

    /**
     * 문자가 모두 대문자인지 체크
     *
     * @param value 값
     * @return 대문자 여부
     */
    public static boolean isUpperCase(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (Character.isLowerCase(value.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 문자가 모두 소문자인지 체크
     *
     * @param value 값
     * @return 소문자 여부
     */
    public static boolean isLowerCase(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (Character.isUpperCase(value.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 연속 문자, 숫자 4자리 체크
     *
     * @param pwd 비밀번호
     * @return 연속 여부
     */
    public static boolean isContinuousPwd(String pwd) {
        int o = 0;
        int d = 0;
        int p = 0;
        int n = 0;
        int limit = 4;

        for (int i = 0; i < pwd.length(); i++) {
            char tempVal = pwd.charAt(i);
            if (i > 0 && (p = o - tempVal) > -2 && (n = p == d ? n + 1 : 0) > limit - 3) {
                return true;
            }
            d = p;
            o = tempVal;
        }
        return false;
    }

    private static boolean cantParseInteger(String val) {
        try {
            Integer.parseInt(val);
            return false;
        } catch (NumberFormatException ex) {
            return true;
        }
    }

    private static boolean cantParseDouble(String val) {
        try {
            Double.parseDouble(val);
            return false;
        } catch (NumberFormatException ex) {
            return true;
        }
    }
}