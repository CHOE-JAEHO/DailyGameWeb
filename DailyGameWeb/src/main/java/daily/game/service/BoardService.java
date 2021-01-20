package daily.game.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daily.game.dao.BoardAttachDAO;
import daily.game.dao.BoardDAO;
import daily.game.dto.BoardAttachDTO;
import daily.game.dto.BoardDTO;
import daily.game.dto.Criteria;

@Service
public class BoardService implements InterBoardService{
	
@Autowired
BoardDAO bdao;
@Autowired
BoardAttachDAO badao;
	@Transactional //트랜젝션. 값을 주면 동시에 값이 빠지는 설계.동시동작.
	public void boardWrite(BoardDTO bdto) {
		bdao.boardWrite(bdto);
		
		//DGWboard에 insert
		System.out.println(bdto.getBno());
		bdto.getAttachList().forEach(attach->{
			attach.setBno(bdto.getBno());
			badao.insert(attach);
		});
		
	}
	
	public ArrayList<BoardDTO> boardList(Criteria cri){
		return bdao.boardList(cri);
	}


	public BoardDTO boardDetail(BoardDTO bdto) {
			
		return bdao.boardDetail(bdto);
	}


	public void boardUpdate(BoardDTO bdto) {
		bdao.boardUpdate(bdto);		
	}


	public void boardDelete(BoardDTO bdto) {
		bdao.boardDelete(bdto);
	}

	@Override
	public int getTotal(Criteria cri) {
		return bdao.getTotal(cri);
	}

	@Override
	public ArrayList<BoardDTO> SboardList() {
		// TODO Auto-generated method stub
		return bdao.SboardList();
	}

	@Override
	public ArrayList<BoardAttachDTO> imgSelect(int bno) {
		
		return badao.imgSelect(bno);
	}
}
