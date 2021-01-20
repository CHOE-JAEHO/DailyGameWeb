package daily.game.dao;

import java.util.ArrayList;

import daily.game.dto.BoardAttachDTO;

public interface WboardAttachDAO {
	public void winsert(BoardAttachDTO battachdto);
	public ArrayList<BoardAttachDTO>wimgSelect(int bno);
}
