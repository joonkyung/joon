package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.BoardVO;
import kr.co.domain.SPageTO;
import kr.co.persistence.SBoardDAO;

@Service
@Transactional
public class SBoardServiceImpl implements SBoardService {

   @Autowired
   private SBoardDAO sbdao;
   
   @Override
   public SPageTO<BoardVO> list(SPageTO<BoardVO> sto) {
      int amount = sbdao.amount(sto);
      sto.setAmount(amount);
      
      List<BoardVO> list = sbdao.list(sto);
      sto.setList(list);

      return sto;
   }

   @Override
   public int amount(SPageTO<BoardVO> to) {
      return sbdao.amount(to);
   }

   @Override
   public BoardVO read(int bno) {
      sbdao.increaseviewcnt(bno);
      return sbdao.read(bno);
   }

   @Override
   public void del(int bno) {
      sbdao.del(bno);
   }

   @Override
   public BoardVO modifyUI(int bno) {
      return sbdao.modifyUI(bno);
   }

   @Override
   public void modify(BoardVO vo) {
      sbdao.modify(vo);
   }

}