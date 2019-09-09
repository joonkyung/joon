package kr.co.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.persistence.BoardDAO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO bdao;

	@Override
	public Integer create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return bdao.create(vo);
	}

	@Override
	public List<BoardVO> listall() {
		// TODO Auto-generated method stub
		return bdao.listall();
	}

	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		bdao.increaseviewcnt(bno);
		return bdao.read(bno);
	}

	@Override
	public void del(int bno) {
		bdao.del(bno);
		
	}

	@Override
	public BoardVO modifyUI(int bno) {
		// TODO Auto-generated method stub
		return bdao.modifyUI(bno);
	}

	@Override
	public void modify(BoardVO vo) {
		bdao.modify(vo);
		
	}

	@Override
	public PageTO list(PageTO to) {
		int amount = bdao.getAmount();
		
		to.setAmount(amount);
		List<BoardVO> list = bdao.list(to);
		to.setList(list);
		return to;
	}

	

	
	
}
