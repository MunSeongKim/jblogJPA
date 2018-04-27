package com.cafe24.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping({"", "/"})
    public String main(){
	System.out.println( "MAIN EXECUTE" );
	return "main/index";
    }
}
