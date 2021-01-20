package daily.game.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daily.game.dao.ReplyDAO;
import daily.game.dto.ReplyDTO;
@Service
public class ReplyService implements interReplyService{
@Autowired
ReplyDAO rdao;
	@Override
	public int replyInsert(ReplyDTO rdto) {
		
		return rdao.replyInsert(rdto);
	}

	@Override
	public ArrayList<ReplyDTO> replySelect(int bno) {
		
		return rdao.replySelect(bno);
	}

	@Override
	public int replyUpdate(ReplyDTO rdto) {
		return rdao.replyUpdate(rdto);
	}

	@Override
	public int replyDelete(ReplyDTO rdto) {

		return rdao.replyDelete(rdto);
	}

}
