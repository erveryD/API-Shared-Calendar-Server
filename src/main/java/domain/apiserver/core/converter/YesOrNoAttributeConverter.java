package domain.apiserver.core.converter;

import domain.apiserver.core.enums.YesOrNo;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * DB 값 <-> 상수 상호 변환
 */
@Converter(autoApply = true)
public class YesOrNoAttributeConverter implements AttributeConverter<YesOrNo, String> {
    @Override
    public String convertToDatabaseColumn(YesOrNo attribute) {
        return null == attribute ? null : attribute.getCode();
    }

    @Override
    public YesOrNo convertToEntityAttribute(String dbData) {
        return YesOrNo.codeOf(dbData).orElse(null);
    }
}
