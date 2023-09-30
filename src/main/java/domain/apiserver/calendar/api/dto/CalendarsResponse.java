package domain.apiserver.calendar.api.dto;

import domain.apiserver.calendar.entity.Calendar;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "캘린더 정보 반환")
public class CalendarsResponse {

    @Schema(description = "캘린더 Id", example = "1")
    private Long id;

    @Schema(description = "캘린더 이름", example = "주요 일정")
    private String name;

    private CalendarsResponse(Calendar calendar) {
        this.id = calendar.getId();
        this.name = calendar.getName();
    }

    public static CalendarsResponse of(Calendar calendar) {
        return new CalendarsResponse(calendar);
    }
}
