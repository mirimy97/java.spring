package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * ( 컴포넌트 스캔과 의존관계 자동 주입 시작하기 )
 */
@Configuration   // 설정 정보 class
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)    // 컴포넌트 스캔 , Filter : 기존 수동으로 설정한 AppConfig class(@Configuration 붙음)를 제외하기 위해 설정해주었다.
public class AutoAppConfig {

}
