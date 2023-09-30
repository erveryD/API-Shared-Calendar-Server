package domain.apiserver.core.converter;

import domain.apiserver.core.enums.YesOrNo;
import org.springframework.core.convert.converter.Converter;

/**
 * 파라메터 문자열을 상수로 변환
 */
public class YesOrNoEnumConverter implements Converter<String, YesOrNo> {
    @Override
    public YesOrNo convert(String value) {
        return YesOrNo.codeOf(value.toUpperCase()).orElse(null);
    }
}
