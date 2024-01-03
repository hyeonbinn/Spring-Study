package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService((MemoryMemberRepository) memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

        //return new MemoryMemberRepository();

        // 다른 코드는 건들지 않고 이 부분만 변경.
        // memory 버전에서 jdbd 버전의 memberRepository로 등록
        return new JdbcMemberRepository(dataSource);
    }
}
