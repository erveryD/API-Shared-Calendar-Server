package domain.apiserver.core.mapper;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 날짜 변환기
 */
public class DateMapper extends ObjectMapper {

    public static final DateTimeFormatter YMD = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter YMD_COMMA = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    public static final DateTimeFormatter YMS = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter YMS_COMMA = DateTimeFormatter.ofPattern(
            "yyyy.MM.dd HH:mm:ss");
    public static final DateTimeFormatter YM = DateTimeFormatter.ofPattern("yyyyMM");
    public static final DateTimeFormatter YM_COMMA = DateTimeFormatter.ofPattern("yyyy.MM");


    public DateMapper() {
        SimpleModule simpleModule = new SimpleModule();

        simpleModule.addSerializer(YearMonth.class, new YearMonthSerializer());
        simpleModule.addDeserializer(YearMonth.class, new YearMonthDeserializer());
        simpleModule.addSerializer(LocalDate.class, new LocalDateSerializer());
        simpleModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        simpleModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        simpleModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());

        super.registerModule(simpleModule);
    }

    /**
     * 응답할 날짜를 문자로 변환
     */
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class YearMonthSerializer extends JsonSerializer<YearMonth> {

        @Override
        public void serialize(YearMonth value, JsonGenerator gen, SerializerProvider serializers)
                throws IOException {
            gen.writeString(value.format(YM_COMMA));
        }
    }

    /**
     * 요청받은 문자를 날짜로 변환
     */
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class YearMonthDeserializer extends JsonDeserializer<YearMonth> {

        @Override
        public YearMonth deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException, JacksonException {
            return YearMonth.parse(p.getValueAsString(), YM);
        }
    }

    /**
     * 응답할 날짜를 문자로 변환
     */
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LocalDateSerializer extends JsonSerializer<LocalDate> {

        @Override
        public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers)
                throws IOException {
            gen.writeString(value.format(YMD_COMMA));
        }
    }

    /**
     * 요청받은 문자를 날짜로 변환
     */
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

        @Override
        public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return LocalDate.parse(p.getValueAsString(), YMD);
        }
    }

    /**
     * 응답할 일시를 문자로 변환
     */
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

        @Override
        public void serialize(LocalDateTime value, JsonGenerator gen,
                SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(YMS_COMMA));
        }
    }

    /**
     * 요청받은 문자를 일시로 변환
     */
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

        @Override
        public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException {
            return LocalDateTime.parse(p.getValueAsString(), YMS);
        }
    }

    /**
     * 응답할 날짜를 (yyyyMMdd)로 변환
     */
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LocalDateYMDSerializer extends JsonSerializer<LocalDate> {

        @Override
        public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers)
                throws IOException {
            gen.writeString(value.format(DateMapper.YMD));

        }
    }

    /**
     * 응답할 일시를 (yyyyMMddHHmmss)로 변환
     */
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LocalDateTimeYMSSerializer extends JsonSerializer<LocalDateTime> {

        @Override
        public void serialize(LocalDateTime value, JsonGenerator gen,
                SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(DateMapper.YMS));
        }
    }

}
