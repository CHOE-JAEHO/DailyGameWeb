package daily.game.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daily.game.dao.WreplyDAO;
import daily.game.dto.ReplyDTO;
@Service
public class WreplyService implements InterWreplyService{
	
@Autowired
WreplyDAO wrdao;
	@Override
	public int wreplyInsert(ReplyDTO rdto) {
		
		return wrdao.wreplyInsert(rdto) ;
	}

	@Override
	public ArrayList<ReplyDTO> wreplySelect(int bno) {
		
		return wrdao.wreplySelect(bno);
	}

	@Override
	public int wreplyUpdate(ReplyDTO rdto) {
		// TODO Auto-generated method stub
		return wrdao.wreplyUpdate(rdto);
	}

	@Override
	public int wreplyDelete(ReplyDTO rdto) {
		// TODO Auto-generated method stub
		return wrdao.wreplyDelete(rdto);
	}

}
