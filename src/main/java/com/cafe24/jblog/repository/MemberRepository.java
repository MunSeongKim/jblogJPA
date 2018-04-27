package com.cafe24.jblog.repository;

import static com.cafe24.jblog.domain.QMember.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cafe24.jblog.domain.Member;
import com.cafe24.jblog.dto.MemberDTO;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

    public void save( Member member ) {
	em.persist( member );
    }

    public void remove( Member target ) {
	JPAQuery query = new JPAQuery( em );
	Member result = query.from( member ).where( member.id.eq( target.getId() ) ).uniqueResult( member );
	System.out.println( "-------------" + em.contains( result ) );

	em.remove( result );
    }

    public MemberDTO findByIdAndPassword( String id, String password ) {
	JPAQuery query = new JPAQuery( em );
	MemberDTO memberDto = query.from( member ).where( member.id.eq( id ), member.password.eq( password ) )
		.uniqueResult( Projections.bean( MemberDTO.class, member.id, member.name, member.regDate ) );
	return memberDto;
    }
}
