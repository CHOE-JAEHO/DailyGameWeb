package daily.game.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import daily.game.dto.BoardAttachDTO;
import daily.game.dto.BoardDTO;
import daily.game.dto.Criteria;
import daily.game.dto.PageDTO;
import daily.game.service.BoardService;
import daily.game.service.WboardService;

@Controller
@RequestMapping("wboard")
public class WboardController {
@Autowired
WboardService wbserv;
	@GetMapping("/boardWrite")
	public void gowboardWrite() {
		
	}
	@RequestMapping(value="boardWrite",method=RequestMethod.POST)
	public String wboardWrite(BoardDTO bdto,Model model) {
		try {
			wbserv.wboardWrite(bdto);
			model.addAttribute("result","success");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/wboard/boardList";}
	
	@GetMapping("/boardList")
	public void wboardList(Criteria cri,Model model) {
		int total = wbserv.getwTotal(cri);
		
		
		model.addAttribute("Wlist", wbserv.wboardList(cri));
		
		
		model.addAttribute("Wpage", new PageDTO(cri,total));
		//cri로 페이지넘버,어마운트(페이지당게시글수)를 가져온다.
	}

	
	@GetMapping("/boardDetail")
	public void wboardDetail(BoardDTO bdto,Model model) {
		
		model.addAttribute("Wdetail",wbserv.wboardDetail(bdto));
		
		
	}
	@GetMapping("/boardUpdate")
	public void gowboardUpdate(BoardDTO bdto,Model model) {
		model.addAttribute("Wdetail",wbserv.wboardDetail(bdto));
	}
	@PostMapping("/boardUpdate")
	public String wboardUpdate(BoardDTO bdto, Model model) {
		wbserv.wboardUpdate(bdto);
		int num=bdto.getBno();
		return "redirect:/wboard/boardDetail?bno="+num;
	}
	@GetMapping("/boardDelete")
	public void gowboardDelete(BoardDTO bdto, Model model) {
		model.addAttribute("Wdetail",wbserv.wboardDetail(bdto));
	}
	@PostMapping("/boardDelete")
	public String boardDelete(BoardDTO bdto) {
		System.out.println("야호호호");
		wbserv.wboardDelete(bdto);
		System.out.println("이히히ㅣㅎ");
		return "redirect:/wboard/boardList";
	}
	
	@RequestMapping(value="/{bno}",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<BoardAttachDTO>> wimgSelect(@PathVariable("bno")int bno){
		
		return new ResponseEntity<>(wbserv.wimgSelect(bno),HttpStatus.OK);
	}
	
}
