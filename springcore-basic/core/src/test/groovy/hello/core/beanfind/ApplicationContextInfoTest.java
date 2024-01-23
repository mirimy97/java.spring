package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " / object = " + bean);
            /**
             * name = org.springframework.context.annotation.internalConfigurationAnnotationProcessor / object = org.springframework.context.annotation.ConfigurationClassPostProcessor@2c07545f
             * name = org.springframework.context.annotation.internalAutowiredAnnotationProcessor / object = org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor@e57b96d
             * name = org.springframework.context.annotation.internalCommonAnnotationProcessor / object = org.springframework.context.annotation.CommonAnnotationBeanPostProcessor@32c726ee
             * name = org.springframework.context.event.internalEventListenerProcessor / object = org.springframework.context.event.EventListenerMethodProcessor@22f31dec
             * name = org.springframework.context.event.internalEventListenerFactory / object = org.springframework.context.event.DefaultEventListenerFactory@34c01041
             * name = appConfig / object = hello.core.AppConfig$$SpringCGLIB$$0@76f4b65
             * name = memberService / object = hello.core.member.MemberServiceImpl@c94fd30
             * name = memberRepository / object = hello.core.member.MemoryMemberRepository@36328d33
             * name = orderService / object = hello.core.order.OrderServiceImpl@2c4d1ac
             * name = discountPolicy / object = hello.core.discount.RateDiscountPolicy@7f0d96f2
             */
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            /**
             * Role - ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
             * Role - ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
             */
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " / object = " + bean);
                /**
                 * name = appConfig / object = hello.core.AppConfig$$SpringCGLIB$$0@2c07545f
                 * name = memberService / object = hello.core.member.MemberServiceImpl@e57b96d
                 * name = memberRepository / object = hello.core.member.MemoryMemberRepository@32c726ee
                 * name = orderService / object = hello.core.order.OrderServiceImpl@22f31dec
                 * name = discountPolicy / object = hello.core.discount.RateDiscountPolicy@34c01041
                 */
            }
        }
    }
}
