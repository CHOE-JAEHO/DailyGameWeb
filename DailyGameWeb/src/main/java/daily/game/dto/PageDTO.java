package daily.game.dto;


public class PageDTO {
	//처음페이지(startPage 1, 6, 11, 16..)
	private int startPage;
	//끝 페이지(endPage 10, 20, 30, 40..)
	private int endPage;
	//이전버튼(true/false)
	private boolean prev;
	//다음버튼(true/false)
	private boolean next;
	//tbl_tboard 건수의 전체 끝번호를 알 수 있는 변수
	private int total;
	//Criteria와 함칠 수 있는 문장.
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri=cri;
		this.total=total;
	
	//endPage 계산식
		this.endPage=(int)(Math.ceil(cri.getPageNum()/5.0))*5;//올림으로 소수점 아이들을 전부 1로 만들고 *10으로 전부 10.
																//같은 방식으로 1.1~~을 2로 올림하고 *10 해서 20 /식을 생각할 때는 멀리까지 통하는 식을 구해야된다.
	//startPage 계산식
		this.startPage=this.endPage-4;
		
	//realEndPage 맨 마지막 페이지만 이것으로 처리.
	int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		if(realEnd<endPage) {
			this.endPage=realEnd;
		}
	//prev 조건
		this.prev=this.startPage>1;

		
	//next 조건
		this.next=this.endPage<realEnd;
	
}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}




}
