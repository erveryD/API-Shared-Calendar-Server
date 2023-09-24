package domain.apiserver.core.config;

import domain.apiserver.core.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Configuration
public class LogAspect {

    @Around("execution(* domain.*.*.api.*Controller.*(..))"
            + " || execution(* domain..application..*Service.*(..))"
            + " || execution(* domain..repository.*Impl.*(..))")
    public Object loggingMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        String type = joinPoint.getSignature().getDeclaringTypeName();
        String name = "";

        stopWatch.start();
        Object retVal = joinPoint.proceed();
        stopWatch.stop();

        if (type.contains("Controller")) {
            name = "Controller  \t:  ";
        } else if (type.contains("Service")) {
            name = "Service     \t:  ";
        } else if (type.contains("Repository")) {
            name = "Repository  \t:  ";
        }

        log.info(String.format("%s[%s.%s] Execute Time : %s", name, type,
                joinPoint.getSignature().getName(),
                DateUtil.toDdhhmmssms(stopWatch.getTotalTimeMillis())));

        return retVal;
    }
}
