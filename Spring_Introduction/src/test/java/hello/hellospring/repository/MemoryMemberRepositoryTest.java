package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach(){
        repository.clearStore(); //test가 한 번 실행되고 끝날 때마다 저장소를 지워줌. 즉 테스트 순서가 상관 없어짐.
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("hyeonbin");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertEquals(member, result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("hyeonbin1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("hyeonbin2");
        repository.save(member2);

        Member result = repository.findByName("hyeonbin1").get();

        assertEquals(member1,result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("hyeonbin1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("hyeonbin2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertEquals(2,result.size());
    }
}
