package domain.apiserver.core.config;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * CreatedBy, LastModifiedBy 설정
 */
@RequiredArgsConstructor
@EnableJpaAuditing
@Configuration
public class JpaAuditConfig implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("system");
    }
}
