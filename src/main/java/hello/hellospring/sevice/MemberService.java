package hello.hellospring.sevice;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Ctrl + Shift + T 커맨드로 Test를 만들수 있다.
//@Service
public class MemberService {

    private final MemberRepository memberRepository;
    //회원가입
    //@Autowired //Spring에 MemoryMemberRepoository를 넣어준다. helloController와 memberRepository 를 연결해주는 역할을 한다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        //중복 회원 제거.
        validateDuplicateMember(member); //중복 회원 검증.

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    //전체조회
    public List<Member> findMembers(){
        return memberRepository.findAll();

    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
