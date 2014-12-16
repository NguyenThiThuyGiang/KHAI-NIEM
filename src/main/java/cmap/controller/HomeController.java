package cmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cmap.services.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	MemberService mems;
	
	@RequestMapping("/e")
	public String index(){
		return "index";
	}
	
	// --- Tạo user tạm thời
	@RequestMapping("/member")
	public String create(){
		mems.addMember("khoa", "admin", "Hoàng Võ Nhật Khoa", false);
		return "home";
	}
	
}


