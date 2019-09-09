package com.naver.no1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.MemberVO;
import kr.co.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberControllerEx {
	@Autowired
	private MemberService mService;
	
	
	// UI로 갈 경우에는 다음과 같이 처리한다.
	
	@RequestMapping(value = "/insertui", method = RequestMethod.GET)
	public void insert() {
				
	}
	
	
	@RequestMapping(value = "/insertui", method = RequestMethod.POST)
	public String insert(MemberVO vo) {
		mService.insert(vo);
		
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/listui", method = RequestMethod.GET)
	public void list(Model model) {
		List<MemberVO> list = mService.list();
		model.addAttribute("list", list);	// 위에 정해져 있기 때문에 /member/list.jsp 로 가게 된다. 
	}
	
}
