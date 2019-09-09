package kr.co.service;

import java.util.List;

import kr.co.domain.MemberVO;

public interface MemberService {
	public abstract void insert(MemberVO vo);
	public abstract MemberVO idcheck(String id);
	public abstract List<MemberVO> list();
	public abstract void delete(String id);
	public abstract MemberVO read(String id);
	public abstract void update(MemberVO vo);
	public abstract MemberVO updateUI(String id);
}
