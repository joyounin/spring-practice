package com.douzone.fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	
	@RequestMapping({"", "/form"})
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping("/upload")
	public String upload(
		@RequestParam("email") String email, 
		@RequestParam("file") MultipartFile file) {
		// 비즈니스에 맞게 file을 다 가져오는게 아니고 URL을 가져온다
		
		String url = filuploadService.restore(file);
		
		return "WEB-INF/views/result.jsp";
	}
}
