package daily.game.dto;

public class ReplyDTO{
	
	private int rno;             //댓글번호
	private int bno;				//게시물번호
	private String reply;			//댓글내용
	private String name;			//작성자
	private String replydate;		//댓글작성일
	private String updatedate;		//댓글수정일
	
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
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReplydate() {
		return replydate;
	}
	public void setReplydate(String replydate) {
		this.replydate = replydate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		
		return bno+","+reply+","+name;
	}
	

}
