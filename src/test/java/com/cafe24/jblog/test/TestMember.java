package com.cafe24.jblog.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe24.jblog.domain.Blog;
import com.cafe24.jblog.domain.Member;
import com.cafe24.jblog.dto.MemberDTO;
import com.cafe24.jblog.repository.BlogRepository;
import com.cafe24.jblog.service.MemberService;

@ContextConfiguration( "classpath:applicationContext.xml" )
@RunWith( SpringJUnit4ClassRunner.class )
@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class TestMember {
    @Autowired
    private MemberService memberService;
    @Autowired
    private BlogRepository blogRepository;
    
    private Member member;

    @Before
    public void setUp() {
	member = new Member();
	member.setId( "dooly" );
	member.setName( "둘리" );
	member.setPassword( "123" );
    }

    @Test
    public void Test01_join() {
	memberService.join( member );
	assertNotNull(member.getId() );
	List<Blog> blogs = blogRepository.findAll();
	System.out.println( blogs );
    }

    @Test
    public void Test02_login() throws ParseException {
	MemberDTO result = memberService.login( "dooly", "123" );
	System.out.println( result );
	assertNotNull( result );
	assertThat( result, instanceOf( MemberDTO.class ) );
	System.out.println( result );
    }
}
