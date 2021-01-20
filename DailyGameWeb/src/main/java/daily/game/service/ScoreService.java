package daily.game.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daily.game.dao.ScoreDAO;
import daily.game.dto.ScoreDTO;

@Service
public class ScoreService implements InterScoreService{
	@Autowired
	ScoreDAO sdao;
	@Override
	public ScoreDTO MSCheck(ScoreDTO sdto) {
		
		return sdao.MSCheck(sdto);
	}
	@Override
	public int Mnewrecord(ScoreDTO sdto) {
			
		return sdao.Mnewrecord(sdto);
	}
	@Override
	public ScoreDTO BSCheck(ScoreDTO dsto) {
		
		return sdao.BSCheck(dsto);
	}
	@Override
	public ArrayList<ScoreDTO> RankList() {
		
		return sdao.RankList();
	}
	@Override
	public int UpdateRecord(ScoreDTO sdto) {
		
		return sdao.UpdateRecord(sdto);
	}

}
