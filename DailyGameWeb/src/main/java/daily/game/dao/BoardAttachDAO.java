package daily.game.dao;

import java.util.ArrayList;

import daily.game.dto.BoardAttachDTO;
import daily.game.dto.BoardDTO;

public interface BoardAttachDAO {

		public void insert(BoardAttachDTO battachdto);
		public ArrayList<BoardAttachDTO>imgSelect(int bno);
}

