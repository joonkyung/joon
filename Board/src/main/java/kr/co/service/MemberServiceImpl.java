package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.MemberVO;
import kr.co.persistence.MemberDAO;

// transaction 있을경우 service에서 처리한다. @Transactional 을 추가하여준다.
@Service
@Transactional
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAO mDAO;
	
	@Override
	public void insert(MemberVO vo) {
		mDAO.insert(vo);
	}

	@Override
	public List<MemberVO> list() {
		
		return mDAO.list();
	}

	@Override
	public MemberVO idcheck(String id) {
	
		return mDAO.idcheck(id);
	}

	@Override
	public void delete(String id) {
		mDAO.delete(id);
		mDAO.insert(new MemberVO(id,"삭제됨",0));
		
	}

	@Override
	public MemberVO read(String id) {
		return mDAO.read(id);
		
	}

	@Override
	public MemberVO updateUI(String id) {
		return mDAO.read(id);
	}

	@Override
	public void update(MemberVO vo) {
		mDAO.update(vo);
		
	}
	
}
