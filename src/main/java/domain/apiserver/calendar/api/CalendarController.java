package domain.apiserver.calendar.api;

import domain.apiserver.calendar.service.RetrieveCalendarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "캘린더")
@RestController(value = "/calendar")
@RequiredArgsConstructor
public class CalendarController {

  private final RetrieveCalendarService retrieveCalendarService;

  @Operation(summary = "구독한 캘린더 목록 조회", tags = "캘린더")
  @ApiResponse(responseCode = "200", description = "ok")
  @ResponseStatus(value = HttpStatus.OK)
  @GetMapping(value = "/member/{member-id}")
  public ResponseEntity<Void> retrieveSubscriptionList(
      @PathVariable("member-id") Long memberId){

    return ResponseEntity.noContent().build();
  }

}
