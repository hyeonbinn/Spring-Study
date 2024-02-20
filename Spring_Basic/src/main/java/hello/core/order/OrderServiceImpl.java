package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    /**생성자 주입은 스프링이 OrderServiceImpl 객체를 생성하려면, 생성자를 불러야함. 빈을 등록하면서 의존관계 주입이 같이 일어남.
     즉 수정자 등의 주입은 생성자 주입 이후에 일어난다는 것.**/
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인 정책에 회원을 그냥 넘기는 것

        return new Order(memberId, itemName, itemPrice, discountPrice); //주문을 만들어 반환해주기만 하면 OrderService의 역할은 끝나는 것
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}