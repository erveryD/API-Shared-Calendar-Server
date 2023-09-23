package domain.apiserver.core.utils;

import domain.apiserver.core.enums.CustomHeader;
import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.time.ZoneId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 요청데이터 유틸
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestUtil {

    /**
     * 현재 컨텍스트 요청데이터 반환
     *
     * @return 요청데이터
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 요청데이터의 IP 반환
     *
     * @param request 요청
     * @return IP
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");

        if (CheckUtil.isNullOrEmpty(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (CheckUtil.isNullOrEmpty(ip)) {
            // 웹로직
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (CheckUtil.isNullOrEmpty(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (CheckUtil.isNullOrEmpty(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (CheckUtil.isNullOrEmpty(ip)) {
            try {
                ip = Inet4Address.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                ip = request.getRemoteAddr();
            }
        }

        return ip;
    }

    /**
     * 요청데이터의 타임존 반환
     *
     * @param request 요청
     * @return 타임존
     */
    public static ZoneId getTimeZone(HttpServletRequest request) {
        if (CheckUtil.isNullOrEmpty(timeZoneHeader(request))) {
            return ZoneId.systemDefault();
        }

        return ZoneId.of(timeZoneHeader(request));
    }

    /**
     * 요청데이터의 타임존 반환 클라이언트의 요청 헤더에 타임존이 없을 경우 기본 값으로 UTC 로 가정하여 반환
     *
     * @return 타임존
     */
    public static ZoneId getTimeZone() {
        if (CheckUtil.isNullOrEmpty(timeZoneHeader())) {
            return ZoneId.systemDefault();
        }

        return ZoneId.of(timeZoneHeader());
    }

    /**
     * 요청데이터의 타임존 반환
     *
     * @return 타임존
     */
    private static String timeZoneHeader() {
        return getRequest().getHeader(CustomHeader.TimeZone.getCode());
    }

    /**
     * 요청데이터의 타임존 반환
     *
     * @param request 요청데이터
     * @return 타임존
     */
    private static String timeZoneHeader(HttpServletRequest request) {
        return request.getHeader(CustomHeader.TimeZone.getCode());
    }

}

