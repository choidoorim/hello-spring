package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //Null을 처리하는 방법으로 Optional을 주로 사용한다.
    Optional<Member> findByName(String name);

    List<Member> findAll();

}
