package com.cafe24.jblog.test.member;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe24.jblog.domain.Member;
import com.cafe24.jblog.service.MemberService;
import com.cafe24.util.EncryptPassword;

@ContextConfiguration( "classpath:applicationContext.xml" )
@RunWith( SpringJUnit4ClassRunner.class )
@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class MemberTest {
    @Autowired
    private MemberService memberService;

    private Member member;

    @Before
    public void setUp() {
	member = new Member();
	member.setId( "dooly" );
	member.setName( "둘리" );
	member.setPassword( EncryptPassword.encrypt( "123" ) );
	member.setRegDate( new Date() );
    }

    @Test
    public void Test01_join() {
	assertTrue( memberService.join( member ) );
    }

    @Test
    public void Test02_login() throws ParseException {
	String result = memberService.login( "dooly", "123" );
	assertNotNull( result );
	
	String[] data = result.split(",");
	Member m = new Member();
	m.setId(data[0]);
	m.setName(data[1]);
	m.setRegDate(new SimpleDateFormat("yyyy-MM-dd").parse(data[2]));
	
	System.out.println( m );
    }
}
