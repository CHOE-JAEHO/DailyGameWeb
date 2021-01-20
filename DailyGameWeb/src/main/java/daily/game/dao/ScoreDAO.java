package daily.game.dao;

import java.util.ArrayList;

import daily.game.dto.ScoreDTO;

public interface ScoreDAO {
	public ArrayList<ScoreDTO> RankList();
	public ScoreDTO MSCheck(ScoreDTO sdto);
	public int Mnewrecord(ScoreDTO sdto);
	public ScoreDTO BSCheck(ScoreDTO dsto);
	public int UpdateRecord(ScoreDTO sdto);
}
