package domain.apiserver.core.config;

import domain.apiserver.core.enums.EnvCd;
import domain.apiserver.core.utils.DateUtil;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 어플리케이션 이벤트 리스너
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AppEventListener {

    private final Environment environment;

    @Value("${custom.version}")
    private String version;

    @Value("${custom.title}")
    private String title;

    /**
     * 어플리케이션 시작 이벤트 리스너
     *
     * @param event 이벤트
     */
    @EventListener
    public void onStartUp(ApplicationReadyEvent event) {
        EnvCd env = EnvCd.codesOf(environment.getActiveProfiles());
        String now = DateUtil.toYmsString(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss");

        log.info("#######################      Server StartUp     #######################");
        log.info("#    Project Name  : {}", title);
        log.info("#    Start Up Time : {}", now);
        log.info("#    Version       : {}", version);
        log.info("#    Profile       : {}({})", env.getTitle(), env.name());
        log.info("#####################################################################\n");
    }

    /**
     * 어플리케이션 종료 이벤트 리스너
     */
    @PreDestroy
    public void onShutDown() {
        String now = DateUtil.toYmsString(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss");

        log.info("#######################      Server ShutDown     #######################");
        log.info("#    Project Name  : {}", title);
        log.info("#    ShutDown Time : {}", now);
        log.info("#####################################################################\n");
    }
}
