package cn.voidtech.gatewayserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * @author RowLingKaslana
 * @project SCExam
 * @date 2023/12/20 15:41
 * This is the honor of the Kaslana family!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // 允许所有源头访问
        config.addAllowedOrigin("*");

        // 允许所有头部信息
        config.addAllowedHeader("*");

        // 允许所有方法（post、get等）
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}
