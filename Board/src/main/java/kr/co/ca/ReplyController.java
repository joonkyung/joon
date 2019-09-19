package kr.co.ca;

import java.util.List;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.domain.ReplyVO;
import kr.co.domain.SPageTO;
import kr.co.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {

	@Inject
	private ReplyService rService;
	//페이징 목록
	@RequestMapping(value = "/{bno}/{replyPage}" , method = RequestMethod.GET)
	public ResponseEntity<PageTO<ReplyVO>> list(@PathVariable("bno") int bno, @PathVariable("replyPage") int replyPage) {
		ResponseEntity<PageTO<ReplyVO>> entity = null;
		try {
			PageTO<ReplyVO> to = rService.list(bno,replyPage);
			entity = new ResponseEntity<PageTO<ReplyVO>>(to,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<PageTO<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/{rno}" , method = RequestMethod.DELETE ,produces = "application/text;charset=utf-8")
	public ResponseEntity<String> delete(@PathVariable("rno") int rno) {
		ResponseEntity<String> entity = null;
		
		
		try {
			rService.delete(rno);
			entity = new ResponseEntity<String>("삭제 성공",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/{rno}" , method = RequestMethod.PUT ,produces = "application/text;charset=utf-8")
	public ResponseEntity<String> update(@PathVariable("rno") int rno, @RequestBody ReplyVO vo) {
		ResponseEntity<String> entity = null;
		vo.setRno(rno);
		
		try {
			rService.update(vo);
			entity = new ResponseEntity<String>("수정 성공",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//목록
	@RequestMapping(value = "/{bno}" , method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") int bno) {
		ResponseEntity<List<ReplyVO>> entity = null;
		try {
			List<ReplyVO> list = rService.list(bno);
			entity = new ResponseEntity<List<ReplyVO>>(list,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "" ,method = RequestMethod.POST,produces = "application/text;charset=utf-8")
	public ResponseEntity<String> insert(@RequestBody ReplyVO vo) {
		ResponseEntity<String> entity = null;
		try {
			rService.insert(vo);
			entity = new ResponseEntity<String>("추가 완료",HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
}
