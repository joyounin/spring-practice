package com.douzone.hellospring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 * @RequestMapping 클래스 단독 매핑
 * Spring mvc 4.x 에서만 지원!!
 *
 */

// @Controller
@RequestMapping("/guestbook/*")
public class GusetbookController {
	
	@ResponseBody
	@RequestMapping("/list")
	public String list() {
		return "GuestbookController.list()";
	} 
	
	@ResponseBody
	@RequestMapping("/delete")
	public String delete() {
		return "GuestbookController.delete()";
	} 
}
