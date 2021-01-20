package daily.game.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import daily.game.dto.BoardDTO;
import daily.game.dto.MemberDTO;
import daily.game.service.MemberService;
//main겸 page Controller 
@Controller
@RequestMapping("main")
public class MainController {
	@Autowired
	MemberService mserv;

	@GetMapping("/Base")
	public void gomain(HttpSession se) {
		System.out.println(se.getAttribute("Lid"));
		System.out.println(se.getAttribute("Lpw"));
	}
	@PostMapping("memberLogin")
	public String memberLogin(MemberDTO mdto, HttpSession se,Model model) {
		try {
		String Iid=mdto.getId();
		String Ipw=mdto.getPw();

		mserv.Login(mdto);
	
		String Oid=mserv.Login(mdto).getId();
		String Opw=mserv.Login(mdto).getPw();
		String Oname=mserv.Login(mdto).getName();
		
		if(Iid.equals(Oid)) {
			if(Ipw.equals(Opw)) {
				se.setAttribute("Lid", Oid);
	
				se.setAttribute("Lname", Oname);
				System.out.println(se.getAttribute("Lid"));
				System.out.println(se.getAttribute("Lname"));
				return "redirect:/main/Base";
			}else {
				System.out.println("111");
				return "redirect:/main/Base";
			}
		}		
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("22");
		return "redirect:/main/Base";
		}
	@GetMapping("/Board")
	public void boardPage(BoardDTO bdto) {

	}
	@GetMapping("/Member")
	public void memberPage() {
		
	}
	
	@GetMapping("/Game")
	public void gamePage(){
		
	}
	@GetMapping("/Wboard")
	public void wboardPage(){
		System.out.println("@*#(*#@(@#@(#*@(*#@");
		
	}
}
