package domain.apiserver.calendar.api;

import domain.apiserver.calendar.api.dto.CalendarsResponse;
import domain.apiserver.calendar.service.ChangeCalendarService;
import domain.apiserver.calendar.service.RetrieveCalendarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "캘린더")
@RestController("/calendar")
@RequiredArgsConstructor
public class CalendarController {

    private final RetrieveCalendarService retrieveCalendarService;
    private final ChangeCalendarService changeCalendarService;

    @Operation(summary = "구독한 캘린더 목록 조회", tags = "캘린더")
    @ApiResponse(responseCode = "200", description = "ok")
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/member/{member-id}")
    public ResponseEntity<List<CalendarsResponse>> retrieveCalendars(
            @PathVariable("member-id") Long memberId) {
        return ResponseEntity.ok(
                retrieveCalendarService.getSubscribedList(memberId));
    }

    @Operation(summary = "캘린더 추가", tags = "캘린더")
    @ApiResponse(responseCode = "201", description = "created")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/member/{member-id}")
    public ResponseEntity<Void> createCalender(@RequestBody @Valid Map<String, String> nameMap,
            @PathVariable("member-id") Long memberId) {

        changeCalendarService.createCalendarAndSubscribe(nameMap.get("name"), memberId);
        return ResponseEntity.noContent().build();
    }

}
