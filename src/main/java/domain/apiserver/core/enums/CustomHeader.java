package domain.apiserver.core.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 커스텀 헤더 상수
 *
 * <pre>
 * {@link #TimeZone} 타임존
 * </pre>
 */
@Getter
@AllArgsConstructor
public enum CustomHeader {
    TimeZone("TZ");

    private final String code;

    /**
     * 코드에 해당되는 열거형 상수를 반환한다.
     *
     * @param code 코드
     * @return 코드에 해당되는 열거형 상수
     */
    public static Optional<CustomHeader> codeOf(String code) {
        return Arrays.stream(values()).filter(val -> val.getCode().equals(code)).findFirst();
    }

    @JsonValue
    @Override
    public String toString() {
        return this.getCode();
    }
}
