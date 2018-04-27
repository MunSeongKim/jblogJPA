package com.cafe24.jblog.repository;

import static com.cafe24.jblog.domain.QBlog.*;
import static com.cafe24.jblog.domain.QMember.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cafe24.jblog.domain.Blog;
import com.cafe24.jblog.domain.Member;
import com.mysema.query.jpa.impl.JPAQuery;

@Repository
public class BlogRepository {
    @PersistenceContext
    private EntityManager em;

    public void save( Blog blog ) {
	em.persist( blog );
    }

    public List<Blog> findAll() {
	JPAQuery query = new JPAQuery( em );
	List<Blog> blogs = query.from( blog ).list( blog );
	return blogs;
    }
    
    public void remove( Blog b ) {
	JPAQuery query = new JPAQuery( em );
	Blog result = query.from( blog ).where( blog.id.eq( b.getId() ) ).uniqueResult( blog );
	System.out.println( "-------------" + em.contains( result ) );

	em.remove( result );
    }
}
