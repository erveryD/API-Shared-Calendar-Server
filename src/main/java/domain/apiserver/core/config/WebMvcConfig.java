package domain.apiserver.core.config;

import domain.apiserver.core.mapper.DateMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvc 설정
 */
@EnableWebMvc
@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final LogInterceptor logInterceptor;

    /**
     * 인터셉터 설정
     *
     * @param registry 레지스트리
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor).addPathPatterns("/**");
    }

//    /**
//     * 파라메터 변환 처리
//     *
//     * @param registry 레지스트리
//     */
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new YearMonthConverter());
//        registry.addConverter(new YesOrNoEnumConverter());
//        registry.addConverter(new GenderEnumConverter());
//        registry.addConverter(new JoinTypeEnumConverter());
//    }

    /**
     * CORS 설정
     *
     * @param registry 레지스트리
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTION")
                .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization",
                        "TZ")
                .maxAge(3600);
    }

    @Bean
    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new DateMapper());

        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jackson2HttpMessageConverter());
    }

}

