package kr.co.domain;

import java.io.Serializable;

public class ReplyVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int rno;
	private int bno;
	private String replytext;
	private String replyyer;
	private String regidate;
	private String updatedate;
	
	public ReplyVO() {
		// TODO Auto-generated constructor stub
	}

	public ReplyVO(int bno, String replytext, String replyyer) {
		super();
		this.bno = bno;
		this.replytext = replytext;
		this.replyyer = replyyer;
	}

	public ReplyVO(int rno, int bno, String replytext, String replyyer, String regidate, String updatedate) {
		super();
		this.rno = rno;
		this.bno = bno;
		this.replytext = replytext;
		this.replyyer = replyyer;
		this.regidate = regidate;
		this.updatedate = updatedate;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getReplytext() {
		return replytext;
	}

	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}

	public String getReplyyer() {
		return replyyer;
	}

	public void setReplyyer(String replyyer) {
		this.replyyer = replyyer;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", bno=" + bno + ", replytext=" + replytext + ", replyyer=" + replyyer
				+ ", regidate=" + regidate + ", updatedate=" + updatedate + "]";
	}
		
	
}
