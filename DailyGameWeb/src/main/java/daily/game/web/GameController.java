package daily.game.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import daily.game.dto.ReplyDTO;
import daily.game.dto.ScoreDTO;
import daily.game.service.ScoreService;

@Controller
@RequestMapping("game")
public class GameController {
@Autowired
ScoreService sserv;
	@GetMapping("/gameList")
	public void gamePage(){
		
	}
	@GetMapping("MoleMain")
	public void MolePage(Model model) {
		
		model.addAttribute("RList", sserv.RankList());
		
	}
	
	
	@RequestMapping(value="/msCheck",method=RequestMethod.POST)
	public ResponseEntity<ScoreDTO> MSCheck(@RequestBody ScoreDTO sdto) {
			System.out.println("여기넘어옴");
			System.out.println(sserv.MSCheck(sdto).getId());
		return new ResponseEntity<>(sserv.MSCheck(sdto),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/getBscore",method=RequestMethod.POST)
	public ResponseEntity<ScoreDTO> BSCheck(@RequestBody ScoreDTO sdto) {
		
		return new ResponseEntity<>(sserv.BSCheck(sdto),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/newRecord",method=RequestMethod.POST)
	
	public ResponseEntity<String> Mnewrecord(@RequestBody ScoreDTO sdto) {
		System.out.println(sdto.getMscore());
		int result=sserv.Mnewrecord(sdto);
	return	result==1?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	@RequestMapping(value="/UpdateRecord",method=RequestMethod.PUT)
	public ResponseEntity<String> UpdateRecord(@RequestBody ScoreDTO sdto) {
		System.out.println(sdto.getMscore());
		int result=sserv.UpdateRecord(sdto);

		
	return	result==1?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
}
