package domain.apiserver.core;

import domain.apiserver.core.enums.EnvCd;
import domain.apiserver.core.enums.Errors;
import domain.apiserver.core.utils.RequestUtil;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 어플리케이션 컨트롤러
 */
@Slf4j
@Tag(name = "공통")
@RestController
@RequiredArgsConstructor
public class CoreController {

    private final Environment environment;

    @Value("${custom.version}")
    private String VERSION;

    @Value("${custom.title}")
    private String TITLE;

    @Operation(summary = "[공통] 서버 정보 조회", tags = "공통")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @GetMapping(value = "/info")
    public String retrieveServerInfo() {
        EnvCd env = EnvCd.codesOf(environment.getActiveProfiles());

        // 서버정보 작성
        StringBuilder appInfo = new StringBuilder();
        appInfo.append(TITLE);
        appInfo.append(" / ").append(String.format("%s(%s)", env.getTitle(), env.name()));
        appInfo.append(" / ").append(VERSION);

        return appInfo.toString();
    }

    @Operation(summary = "[공통] 서버 헬스체크", tags = "공통")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @GetMapping(value = "/check")
    public ResponseEntity<HttpStatus> retrieveServerHealthCheck() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "[공통] 서버 시간 조회", tags = "공통")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @GetMapping(value = "/time")
    public ResponseEntity<String> retrieveServerTime(HttpServletRequest request) {
        return new ResponseEntity<>(
                ZonedDateTime.now().withZoneSameInstant(RequestUtil.getTimeZone(request))
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                HttpStatus.OK);
    }

    @Operation(summary = "[공통] 에러 목록 조회", tags = "공통")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @GetMapping(value = "/errors")
    public ResponseEntity<Map<String, String>> retrieveErrors() {
        return ResponseEntity.ok(
                Arrays.stream(Errors.values())
                        .collect(Collectors.toMap(
                                Enum::name,
                                Errors::getCodeMessage,
                                (k, v) -> v, LinkedHashMap::new)));
    }
}
