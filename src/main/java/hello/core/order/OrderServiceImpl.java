package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor    //생성자를 만들어주기 때문에 코드가 깔끔해진다.
public class OrderServiceImpl implements OrderService {
    //setter에 의해 의존관계를 주입
    //private MemberRepository memberRepository;
    //private DiscountPolicy discountPolicy;
    //private final DiscountPolicy discountPolicy = new FixDisxountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //interface에 의존하도록 변경
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
/*
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("1. OrderServiceImpl.orderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);


        return new Order(memberId,itemName, itemPrice, discountPrice);
    }

    //테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
