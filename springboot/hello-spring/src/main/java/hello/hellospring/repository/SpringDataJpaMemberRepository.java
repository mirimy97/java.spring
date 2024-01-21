package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// extends(상속) JpaRepository<테이블, 식별자 타입>
// interface지만, JpaRepository를 상속받고 있으면 Spring이 자동으로 구현체를 만들어서 Spring Bean에 등록해준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

//    JPQL : select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
