package kr.co.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.PageTO;
import kr.co.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Autowired
	private SqlSession session;

	private final String NS = "kr.co.mapper.reply";

	@Override
	public void insert(ReplyVO vo) {

		session.insert(NS + ".insert", vo);

	}

	@Override
	public List<ReplyVO> list(int bno) {
		// TODO Auto-generated method stub
		return session.selectList(NS+".list", bno);
	}

	@Override
	public void update(ReplyVO vo) {
		session.update(NS+".update", vo);
		
	}

	@Override
	public void delete(int rno) {
		session.delete(NS+".delete", rno);
		
	}

	@Override
	public int getAmount(int bno) {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".getAmount",bno);
	}

	@Override
	public List<ReplyVO> list(int bno, PageTO<ReplyVO> to) {
		RowBounds rb = new RowBounds(to.getStartNum()-1,to.getPerPage());
		return session.selectList(NS+".list", bno, rb);
	}

	
}