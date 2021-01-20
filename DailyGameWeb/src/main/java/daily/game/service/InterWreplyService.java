package daily.game.service;

import java.util.ArrayList;

import daily.game.dto.ReplyDTO;

public interface InterWreplyService {
	public int wreplyInsert(ReplyDTO rdto);
	//댓글 조회
	public ArrayList<ReplyDTO> wreplySelect(int bno);
	//댓글 수정
	public int wreplyUpdate(ReplyDTO rdto);
	//댓글 삭제
	public int wreplyDelete(ReplyDTO rdto);
}
