package daily.game.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import daily.game.dto.MemberDTO;
import daily.game.dto.ReplyDTO;
import daily.game.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {

		@Autowired
		MemberService mserv;
	
	@GetMapping("/gomemberJoin")
	public String goJoin() {
		
	return "/member/memberJoin"; }
	
	@RequestMapping(value="/memberJoin",method=RequestMethod.POST)
	public ResponseEntity<String> memberJoin(@RequestBody MemberDTO mdto) {
	
		int result=mserv.Join(mdto);
		return result==1?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@GetMapping("gomemberLogin")
	public String gomemberLogin() {
		
		return "/member/memberLogin";
	}
	
	@PostMapping("memberLogin")
	public String memberLogin(MemberDTO mdto, HttpSession se,Model model) {
	
		String Iid=mdto.getId();
		String Ipw=mdto.getPw();
		String Oid = null;
		String Opw= null;
		String Oname= null;
		String Ogen= null;
		try {
		mserv.Login(mdto);
	
		Oid=mserv.Login(mdto).getId();
		Opw=mserv.Login(mdto).getPw();
		Oname=mserv.Login(mdto).getName();
		Ogen=mserv.Login(mdto).getGen();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(Iid.equals(Oid)) {
			if(Ipw.equals(Opw)) {
				se.setAttribute("Lid", Oid);
				se.setAttribute("Lpw", Opw);
				se.setAttribute("Lname",Oname );
				se.setAttribute("Lgen", Ogen);
				
				return "redirect:/member/gomemberLogin";
			}else {
				
				int ok=1;
				se.removeAttribute("failid");
				se.setAttribute("failpw", ok);
				return "redirect:/member/gomemberLogin";
			}
		}else {		
		 int ok=1;
		 se.removeAttribute("failpw");
		 se.setAttribute("failid", ok);
		return "redirect:/member/gomemberLogin";
			}
		}
	@GetMapping("/memberLogout")
	public String memberLogout(HttpSession se) {
			se.invalidate();
		return "/main/Base";}

	@GetMapping("/memberList")
	public String memberList(Model model) {
		model.addAttribute("list", mserv.List());
		return "/member/memberList";}
	
	@GetMapping("/memberDetail")
	public String memberDetail(MemberDTO mdto, Model model) {
		model.addAttribute("detail", mserv.Detail(mdto));
	 return "/member/memberDetail";}

	@GetMapping("/memberUpdate")
	public String goUPdate(MemberDTO mdto, Model model) {
		model.addAttribute("detail", mserv.Detail(mdto));
		return "/member/memberUpdate";}
	
	@PostMapping("/memberUpdate")
	public String memberUpdate(MemberDTO mdto) {
		mserv.Update(mdto);
		String id=mdto.getId();
		return "redirect:/member/memberDetail?id="+id;
	}
	
	@PostMapping("/gomemberDelete")
	public String goDelete(MemberDTO mdto,Model model) {
		model.addAttribute("detail", mserv.Detail(mdto));
	 return "/member/memberDelete";}
	
	@RequestMapping(value="/memberDelete",method=RequestMethod.DELETE)
	public ResponseEntity<String> memberDelete(@RequestBody MemberDTO mdto) {
		
		int result=mserv.Delete(mdto);


		return result==1?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	@RequestMapping(value="/idCheck",method=RequestMethod.POST)
	public ResponseEntity<String> idCheck(@RequestBody MemberDTO mdto,Model model) {
		String Wid=mdto.getId();
		String Cid="";
		try {
			
		Cid=mserv.Detail(mdto).getId(); 
		if(Cid==null) {
			
			Cid="사용가능한 아이디";
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(Wid);
		System.out.println(Cid);
		/*
		try {	
		String Wid=mdto.getId();
		String Cid=mserv.Detail(mdto).getId(); 
		return Wid!=Cid?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		return Wid.equals(Cid)?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		
	
	
	}
	
	@RequestMapping(value="/nameCheck",method=RequestMethod.POST)
	public ResponseEntity<String> nameCheck(@RequestBody MemberDTO mdto, Model model) {
		String Wname=mdto.getName();
		String Cname="";
		try {
		
		Cname=mserv.NDetail(mdto).getName();
			
		if(Cname==null) {
			
			Cname="사용가능한 닉네임";
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(Wname);
		System.out.println(Cname);
		/*
		try {	
		String Wid=mdto.getId();
		String Cid=mserv.Detail(mdto).getId(); 
		return Wid!=Cid?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		return Wname.equals(Cname)?new ResponseEntity<>("success",HttpStatus.OK)
				:new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
		
	
	
	}
}
