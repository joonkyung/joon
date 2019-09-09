package kr.co.ca;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	@Inject
	private BoardService bService;
	
	@RequestMapping(value = "/create" ,method = RequestMethod.GET)
	public void createUI() {
		
	}
	@RequestMapping(value = "/create" ,method = RequestMethod.POST)
	public String create(BoardVO vo) throws Exception {
		System.out.println(vo.getBno());
		int reNum = bService.create(vo);
		System.out.println(reNum);
		System.out.println(vo.getBno());
		return "redirect:/board/listall";
	}
	
	@RequestMapping("/listall")
	public String listall(Model model) throws Exception {
		List<BoardVO> list = bService.listall();
		model.addAttribute("list", list);
		return "/board/listall";
	}
	@RequestMapping("/read")
	public void read(int bno,Model model) {
		BoardVO vo = bService.read(bno);
		model.addAttribute("vo",vo);
	}
	@RequestMapping(value = "/modify" , method = RequestMethod.GET)
	public void modifyUI(int bno, Model model) {
		BoardVO vo = bService.modifyUI(bno);
		model.addAttribute("vo",vo);
	}
	@RequestMapping(value = "/modify" , method = RequestMethod.POST)
	public String modify(BoardVO vo) {
		bService.modify(vo);
		return "redirect:/board/read?bno="+vo.getBno();
	}
	
	@RequestMapping(value = "/del" ,method = RequestMethod.POST)
	public String del(int bno) throws Exception {
		bService.del(bno);
		
		return "redirect:/board/listall";
	}
	@RequestMapping("/list")
	public void list(PageTO to ,Model model ) {
		System.out.println(to.getPerPage()+"#################");
		PageTO dbto = bService.list(to);
		System.out.println(to.getPerPage()+"*****************");
		System.out.println(dbto.getPerPage()+"::::::::::::::");
		model.addAttribute("to", dbto);
	}
	
}
