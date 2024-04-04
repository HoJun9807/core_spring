package com.hello.core.discount;

import com.hello.core.member.Member;

public interface DiscountPolicy {

    //할인정책

    int discount(Member member, int price);
}
