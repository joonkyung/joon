package kr.co.ca;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "redirect:/board/list";
	}
	
	@RequestMapping("/listall")
	public String listall(Model model) throws Exception {
		List<BoardVO> list = bService.listall();
		model.addAttribute("list", list);
		return "/board/listall";
	}
	
	@RequestMapping("/read")
	public void read(int bno,Model model ,PageTO<BoardVO> to) {
		BoardVO vo = bService.read(bno);
		model.addAttribute("vo",vo);
		model.addAttribute("to", to);
	}
	@RequestMapping(value = "/modify" , method = RequestMethod.GET)
	public void modifyUI(int bno, Model model,PageTO<BoardVO> to) {
		BoardVO vo = bService.modifyUI(bno);
		model.addAttribute("vo",vo);
		model.addAttribute("to", to);
	}
	@RequestMapping(value = "/modify" , method = RequestMethod.POST)
	public String modify(BoardVO vo ,PageTO<BoardVO> to) {
		bService.modify(vo);
		
		return "redirect:/board/read?bno="+vo.getBno()+"&curPage="+to.getCurPage()+"&perPage="+to.getPerPage();
	}
	
	@RequestMapping(value = "/del" ,method = RequestMethod.POST)
	public String del(int bno ,PageTO<BoardVO> to,BoardVO vo) throws Exception {
		bService.del(bno);
		
		return "redirect:/board/list?bno="+vo.getBno()+"&curPage="+to.getCurPage()+"&perPage="+to.getPerPage();
	}
	@RequestMapping("/list")
	public void list(PageTO<BoardVO> to ,Model model ) {
		
		PageTO<BoardVO> dbto = bService.list(to);

		model.addAttribute("to", dbto);
	}
	@RequestMapping("/search")
	public void search(PageTO<BoardVO> to ,Model model ) {
		
		PageTO<BoardVO> dbto = bService.list(to);

		model.addAttribute("to", dbto);
	}
	
	@RequestMapping("/amount/{perPage}")
	@ResponseBody
	public int list(@PathVariable("perPage") int perPage) {
		
		int amount = bService.amount();
		return (amount-1)/perPage+1;
	}
	
}
