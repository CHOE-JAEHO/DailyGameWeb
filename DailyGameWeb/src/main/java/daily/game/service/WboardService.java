package daily.game.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daily.game.dao.WboardAttachDAO;
import daily.game.dao.WboardDAO;
import daily.game.dto.BoardAttachDTO;
import daily.game.dto.BoardDTO;
import daily.game.dto.Criteria;

@Service
public class WboardService implements InterWboardService{
@Autowired
WboardDAO wbdao;
@Autowired
WboardAttachDAO wbadao;
	
	@Transactional
	public void wboardWrite(BoardDTO bdto) {
			wbdao.wboardWrite(bdto);
			
			bdto.getAttachList().forEach(attach->{
				attach.setBno(bdto.getBno());
				wbadao.winsert(attach);
			});
	}

	
	public ArrayList<BoardDTO> wboardList(Criteria cri) {
		
		return wbdao.wboardList(cri);
	}


	public BoardDTO wboardDetail(BoardDTO bdto) {
		return wbdao.wboardDetail(bdto);
	}

	@Override
	public void wboardUpdate(BoardDTO bdto) {
		wbdao.wboardUpdate(bdto);
		
	}

	@Override
	public void wboardDelete(BoardDTO bdto) {
		wbdao.wboardDelete(bdto);
	}

	@Override
	public int getwTotal(Criteria cri) {
	
		return wbdao.getwTotal(cri);
	}

	@Override
	public ArrayList<BoardAttachDTO> wimgSelect(int bno) {
		
		return wbadao.wimgSelect(bno);
	}


}
