package com.hello.core.member;

public class MemberServiceImpl implements MemberService{
    //구현체

    private final MemberRepository memberRepository;
    // MemberRepository 인터페이스에만 의존, DI

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
