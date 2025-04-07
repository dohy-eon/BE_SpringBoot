package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findById(long id);

}
