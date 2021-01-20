package daily.game.service;

import java.util.ArrayList;

import daily.game.dto.ScoreDTO;

public interface InterScoreService {

	public ArrayList<ScoreDTO> RankList();
	public ScoreDTO MSCheck(ScoreDTO sdto);
	public ScoreDTO BSCheck(ScoreDTO dsto);
	public int Mnewrecord(ScoreDTO sdto);
	public int UpdateRecord(ScoreDTO sdto);
}
