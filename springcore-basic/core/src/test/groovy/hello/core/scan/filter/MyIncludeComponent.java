package hello.core.scan.filter;

import java.lang.annotation.*;

/**
 * 커스텀 어노테이션 : 이 어노테이션이 붙은 class는 컴포넌트에 추가하겠다.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
