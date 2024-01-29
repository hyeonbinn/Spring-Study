package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository(); //회원 찾아 와야 하므로 필요


    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy; // 구체화가 아닌 추상화(인터페이스)에만 의존하도록 변경. (DIP O)

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인 정책에 회원을 그냥 넘기는 것

        return new Order(memberId, itemName, itemPrice, discountPrice); //주문을 만들어 반환해주기만 하면 OrderService의 역할은 끝나는 것
    }
}

    /* OrderService 입장에서는 할인에 대한 건 모르고, discountPolicy가 알아서 한 후 결과만 돌려받는 것!!
       => 단일 책임 원칙이 잘 지켜진 것. If 할인 정책이 변경 되면 할인 부분만 변경하면 되므로!
       만약 discountPolicy가 없었다면, 할인 관련 변경이 들어왔어도 OrderService를 고쳐야했을 것 */
