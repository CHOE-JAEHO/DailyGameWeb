package daily.game.dto;

public class ScoreDTO {
	private int ranking;
	private String id;
	private String mscore;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public String getMscore() {
		return mscore;
	}
	public void setMscore(String mscore) {
		this.mscore = mscore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
