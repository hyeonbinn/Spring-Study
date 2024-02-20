package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /** 생성자 주입 : 불변, 필수 의존 관계에 사용
     * memberRepository ,discountPolicy는 한 번 생성되면 못 바꿈. **/
    //@Autowired : 생성자가 1개만 있으면 @Autowired를 생략 가능.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**아래와 같이 public으로 열어놓는 수정 메서드를 만들어놓는 것은 매우 안 좋음.**/
//    public void setDiscountPoilcy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }
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