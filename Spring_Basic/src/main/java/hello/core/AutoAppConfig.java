package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        /** 예제 코드를 살리기 위해 쓴 코드. AppConfig에서 @Bean으로 수동으로 등록하고 있기에 충돌나지 않도록 제외하는 코드를 추가한 것. 원래는 없어도 되는 코드 **/
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

)

public class AutoAppConfig {
//    @Bean(name = "memoryMemberRepository") // 자동으로 등록된 빈의 이름과 같도록 수동 설정 해봄.
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
