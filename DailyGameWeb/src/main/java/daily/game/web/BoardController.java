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


@Controller
@RequestMapping("board")
public class BoardController {
@Autowired
BoardService bserv;
	@GetMapping("/boardWrite")
	public void goboardWrite() {
		
	}
	@RequestMapping(value="boardWrite",method=RequestMethod.POST)
	public String boardWrite(BoardDTO bdto,Model model) {
		
		try {
		bserv.boardWrite(bdto);
		model.addAttribute("result","success");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/boardList";}
	
	@GetMapping("/boardList")
	public void boardList(Criteria cri,Model model) {
		int total = bserv.getTotal(cri);
				
		model.addAttribute("List", bserv.boardList(cri));
		
		
		model.addAttribute("page", new PageDTO(cri,total));
		
	
		//cri로 페이지넘버,어마운트(페이지당게시글수)를 가져온다.
	}
	
	@GetMapping("/SboardList")
	public void SboardList(Model model) {
		
		model.addAttribute("List", bserv.SboardList());

		//cri로 페이지넘버,어마운트(페이지당게시글수)를 가져온다.
	}
	
	@GetMapping("/boardDetail")
	public void boardDetail(BoardDTO bdto,Model model) {
		
		model.addAttribute("Detail",bserv.boardDetail(bdto));
		
		
	}
	@GetMapping("/boardUpdate")
	public void goboardUpdate(BoardDTO bdto,Model model) {
		model.addAttribute("Detail",bserv.boardDetail(bdto));
	}
	@PostMapping("/boardUpdate")
	public String boardUpdate(BoardDTO bdto, Model model) {
		bserv.boardUpdate(bdto);
		int num=bdto.getBno();
		return "redirect:/board/boardDetail?bno="+num;
	}
	@GetMapping("/boardDelete")
	public void goboardDelete(BoardDTO bdto, Model model) {
		model.addAttribute("Detail",bserv.boardDetail(bdto));
	}
	@PostMapping("/boardDelete")
	public String boardDelete(BoardDTO bdto) {
		bserv.boardDelete(bdto);
		return "redirect:/board/boardList";
	}
	@RequestMapping(value="/{bno}",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<BoardAttachDTO>> replySelect(@PathVariable("bno")int bno){
		System.out.println("dlsdlfdls");
		return new ResponseEntity<>(bserv.imgSelect(bno),HttpStatus.OK);
	}
	
}
