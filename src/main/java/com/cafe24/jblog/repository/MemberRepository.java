package com.cafe24.jblog.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.domain.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, String> {
    @Query("SELECT m.id, m.name, m.regDate FROM Member m WHERE m.id=:id AND m.password=:password")
    public String findOneByIdAndPassword(@Param("id") String id, @Param("password") String encPassword);
}
