package com.cafe24.jblog.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.jblog.domain.Member;
import com.cafe24.jblog.service.MemberService;

@Controller
@RequestMapping( "/member" )
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping( value = "/join", method = RequestMethod.GET )
    public String joinGet(@ModelAttribute Member member) {
	System.out.println( "JOIN EXECUTED" );
	return "member/join";
    }

    @RequestMapping( value = "/join", method = RequestMethod.POST )
    public String joinPost( @ModelAttribute Member member ) {
	member.setRegDate(new Date());
	memberService.join(member);
	return "redirect:/";
    }
}
