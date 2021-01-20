package daily.game.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import daily.game.dto.ReplyDTO;
import daily.game.service.WreplyService;

@RestController //컨트롤러 종류도 설정해준다.
@RequestMapping(value="wreplies",method=RequestMethod.GET)
public class WreplyController {
	@Autowired
	WreplyService wrserv;  
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public ResponseEntity<String> replyInsert(@RequestBody ReplyDTO rdto) {
		System.out.println("rdto"+rdto);
		
		int result=wrserv.wreplyInsert(rdto);
	return	result==1?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	@RequestMapping(value="/{bno}",method=RequestMethod.GET)
		public ResponseEntity<ArrayList<ReplyDTO>> replySelect(@PathVariable("bno")int bno){
			
			return new ResponseEntity<>(wrserv.wreplySelect(bno),HttpStatus.OK);
		}
	
	@RequestMapping(value="/new",method=RequestMethod.DELETE)
	public ResponseEntity<String> replyDelete(@RequestBody ReplyDTO rdto){
		
		int result=wrserv.wreplyDelete(rdto);
	 	
	return	result==1?new ResponseEntity<>("success",HttpStatus.OK)
			:new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);

	
	}
	@RequestMapping(value="/new",method=RequestMethod.PUT)
	public ResponseEntity<String>replyUpdate(@RequestBody ReplyDTO rdto){
		
		int result=wrserv.wreplyUpdate(rdto);
	 	
	 	
		return	result==1?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	
	}
