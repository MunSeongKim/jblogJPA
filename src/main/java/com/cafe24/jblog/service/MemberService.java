package com.cafe24.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.jblog.domain.Member;
import com.cafe24.jblog.repository.MemberRepository;
import com.cafe24.util.EncryptPassword;

@Service
@Transactional
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public boolean join( Member member ) {
	if ( memberRepository.save( member ) == null ) {
	    return false;
	}
	return true;
    }
    
    public String login( String id, String password ) {
	return memberRepository.findOneByIdAndPassword( id, EncryptPassword.encrypt( password ) );
    }
}