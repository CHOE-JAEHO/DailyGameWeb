package daily.game.service;

import java.util.ArrayList;

import daily.game.dto.ReplyDTO;


public interface interReplyService {
	//댓글 삽입
		public int replyInsert(ReplyDTO rdto);
		//댓글 조회
		public ArrayList<ReplyDTO> replySelect(int bno);
		//댓글 수정
		public int replyUpdate(ReplyDTO rdto);
		//댓글 삭제
		public int replyDelete(ReplyDTO rdto);

}
