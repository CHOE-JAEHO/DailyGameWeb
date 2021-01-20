package daily.game.service;

import java.util.ArrayList;

import daily.game.dto.MemberDTO;

public interface InterMemberService {
	
	public int Join(MemberDTO mdto);

	public ArrayList<MemberDTO>List();
	
	public MemberDTO Detail(MemberDTO mdto);
	
	public void Update(MemberDTO mdto);
	
	public int Delete(MemberDTO mdto);
	
	public MemberDTO Login(MemberDTO mdto);
	
	public MemberDTO NDetail(MemberDTO mdto);
	
}
