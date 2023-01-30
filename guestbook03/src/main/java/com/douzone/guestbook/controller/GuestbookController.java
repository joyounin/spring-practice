package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	@Autowired
	private GuestbookRepository guestbookrepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookrepository.findAll();
		model.addAttribute("list", list);
		return "WEB-INF/views/index.jsp";
	}

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(GuestbookVo vo) {
		guestbookrepository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/deleteform", method=RequestMethod.GET )
	public String deleteform(@RequestParam("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping(value="/deleteform", method=RequestMethod.POST)
	public String deleteform(@RequestParam("no") Long no, @RequestParam("password") String password ) {
		guestbookrepository.deleteByPassword(no, password);
		return "redirect:/";
	}
	
}
