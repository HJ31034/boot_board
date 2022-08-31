package com.board.controller;

 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 

@Controller
@RequestMapping(value = "/test")
public class testController {
	
	@RequestMapping(value = "/")
	public String selectFollow() {
		
		 
		   
		  return "board/NewFile";
	}
 

}
