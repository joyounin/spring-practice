package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@ResponseBody
	@RequestMapping({"/","/main","/a/b/c/main"}) // 계층구조로 URL을 딸 수 있다.
	public String main() {
		return "MainController:main()";
	}
}
