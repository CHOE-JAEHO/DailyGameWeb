package daily.game.dto;

import java.util.ArrayList;

public class BoardDTO {
	private int bno;
	private String ti;
	private String ct;
	private String name;
	private String regdate;
	private String updatedate;
	private ArrayList<BoardAttachDTO> attachList;//다중파일을 받기위한.
	
	
	public ArrayList<BoardAttachDTO> getAttachList() {
		return attachList;
	}
	public void setAttachList(ArrayList<BoardAttachDTO> attachList) {
		this.attachList = attachList;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTi() {
		return ti;
	}
	public void setTi(String ti) {
		this.ti = ti;
	}
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	
	
}
