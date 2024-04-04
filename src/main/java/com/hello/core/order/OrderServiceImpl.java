package com.hello.core.order;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    // 기능을 실행하는 책임만 지게 됨

    private final MemberRepository memberRepository;
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // 구현체에 의존하고 있다 => DIP/OCP 위반
    private final DiscountPolicy discountPolicy;
    // 인터페이스에 의존 / 구현체에 의존x
    // 하지만 구현체에 의존하고 있던 해당 코드를 위와 같이 인터페이스에 의존하게 만들어도 해당 값에는 null 밖에 들어가지 않아 오류가 발생

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
