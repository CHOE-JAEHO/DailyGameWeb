package daily.game.dto;

public class Criteria {
	//페이지 수 1,2,3,4,)
		private int pageNum;
		
		//페이지당 처리되어야 할 데이터 수 10
		private int amount;

		private String type;
		//검색 조건의 셀랙트 변수
		private String keyword;
		//검색어 변수
		public Criteria() {
			this(1,10);//다른 생성자 호출, (pageNum,amount)↓
		//			↓}
		//			↓
		}
		public Criteria (int pageNum, int amount) {
			this.pageNum=pageNum;
			this.amount=amount;
		}
		
		public int getPageNum() {
			return pageNum;
		}
		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getKeyword() {
			return keyword;
		}
		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}

}
