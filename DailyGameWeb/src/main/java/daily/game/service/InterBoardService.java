package daily.game.service;

import java.util.ArrayList;

import daily.game.dto.BoardAttachDTO;
import daily.game.dto.BoardDTO;
import daily.game.dto.Criteria;


public interface InterBoardService {
	
	public void boardWrite(BoardDTO bdto);
	public ArrayList<BoardDTO> boardList(Criteria cri);
	public ArrayList<BoardDTO> SboardList();
	public BoardDTO boardDetail(BoardDTO bdto);
	public void boardUpdate(BoardDTO bdto);
	public void boardDelete(BoardDTO bdto);
	public int getTotal(Criteria cri);
	public ArrayList<BoardAttachDTO>imgSelect(int bno);
	
}
