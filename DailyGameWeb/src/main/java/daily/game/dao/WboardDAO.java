package daily.game.dao;

import java.util.ArrayList;

import daily.game.dto.BoardAttachDTO;
import daily.game.dto.BoardDTO;
import daily.game.dto.Criteria;

public interface WboardDAO {
	public void wboardWrite(BoardDTO bdto);
	public ArrayList<BoardDTO> wboardList(Criteria cri);

	public BoardDTO wboardDetail(BoardDTO bdto);
	public void wboardUpdate(BoardDTO bdto);
	public void wboardDelete(BoardDTO bdto);
	public int getwTotal(Criteria cri);
	public ArrayList<BoardAttachDTO>wimgSelect(int bno);
}
