package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.domain.ReplyVO;
import kr.co.persistence.ReplyDAO;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO dao;

	@Override
	public void insert(ReplyVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<ReplyVO> list(int bno) {
		// TODO Auto-generated method stub
		return dao.list(bno);
	}

	@Override
	public void update(ReplyVO vo) {
		dao.update(vo);
		
	}

	@Override
	public void delete(int rno) {
		dao.delete(rno);
		
	}

	@Override
	public PageTO<ReplyVO> list(int bno, int replyPage) {
		int amount = dao.getAmount(bno);
		PageTO<ReplyVO> to = new PageTO<ReplyVO>(replyPage);
		to.setAmount(amount);
		List<ReplyVO> list = dao.list(bno,to);
		to.setList(list);
		return to;
	}

}