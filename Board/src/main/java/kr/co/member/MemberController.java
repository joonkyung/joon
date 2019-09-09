package kr.co.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.MemberVO;
import kr.co.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	@Autowired
	private MemberService mService;
	
	
	// UI로 갈 경우에는 다음과 같이 처리한다.
	@RequestMapping("/update")
	public void updateUI(String id, Model model) {
		MemberVO vo = mService.updateUI(id);
		model.addAttribute("vo",vo);
	}
	@RequestMapping(value = {"/update","UPDATE"} , method = RequestMethod.POST)
	public String update(MemberVO vo) {
		mService.update(vo);
		
		return "redirect:/member/read?id="+vo.getId();
	}
	@RequestMapping("/read")
	public void read(String id, Model model) {
				MemberVO vo = mService.read(id);
				model.addAttribute("vo",vo);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
				mService.delete(id);
				return "redirect:/member/list";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert() {
				
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(MemberVO vo) {
		mService.insert(vo);
		
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) {
		List<MemberVO> list = mService.list();
		model.addAttribute("list", list);	// 위에 정해져 있기 때문에 /member/list.jsp 로 가게 된다. 
	}
	
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST, produces = "application/text;charset=utf-8")
	@ResponseBody
	public String idcheck(String id) {
				MemberVO what= mService.idcheck(id);
				
				if(what==null) {
					return "사용가능";
					
				}else {
					return "중복아이디";
				}
				
	}
}
