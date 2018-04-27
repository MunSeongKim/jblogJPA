package com.cafe24.jblog.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.jblog.domain.Blog;
import com.cafe24.jblog.domain.Member;
import com.cafe24.jblog.dto.MemberDTO;
import com.cafe24.jblog.repository.BlogRepository;
import com.cafe24.jblog.repository.MemberRepository;
import com.cafe24.util.EncryptPassword;

@Service
@Transactional
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BlogRepository blogRepository;
    
    public void join( Member member ) {
	String encryptedPassword = EncryptPassword.encrypt( member.getPassword() );
	member.setPassword( encryptedPassword );
	member.setRegDate( new Date() );

	Blog blog = new Blog();
	blog.setTitle( member.getName() + "'s Blog");
	blog.setImagePath( "/assets/images/default_logo.png" );
	// FK 매핑
	blog.setMember(member);
	
	memberRepository.save( member );
	blogRepository.save( blog );
	System.out.println( "----------------" );
	blogRepository.remove(blog);
    }
    
    public MemberDTO login( String id, String password ) {
	return memberRepository.findByIdAndPassword( id, EncryptPassword.encrypt( password ) );
    }
}