package daily.game.dao;

import java.util.ArrayList;

import daily.game.dto.BoardDTO;
import daily.game.dto.Criteria;

public interface BoardDAO {
	
	public void boardWrite(BoardDTO bdto);
	public ArrayList<BoardDTO> boardList(Criteria cri);
	public ArrayList<BoardDTO> SboardList();
	public BoardDTO boardDetail(BoardDTO bdto);
	public void boardUpdate(BoardDTO bdto);
	public void boardDelete(BoardDTO bdto);
	public int getTotal(Criteria cri);

}
