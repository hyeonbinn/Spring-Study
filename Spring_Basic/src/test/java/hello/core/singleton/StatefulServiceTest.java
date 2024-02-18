package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


class StatefulServiceTest {

    @Test
    void statusfulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA에서 userA가 10000원을 주문함.
        int userAPrice = statefulService1.order("userA", 10000);

        //ThreadB에서 userB가 20000원을 주문함.
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA에서 userA의 주문 금액 조회
        //int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice); // 기대 금액 : 10000 / 실제 출력 : 10000

        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000); //ture 출력 => 이러면 안됨..!
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}