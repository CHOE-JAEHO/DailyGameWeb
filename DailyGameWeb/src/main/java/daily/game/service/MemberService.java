package daily.game.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daily.game.dao.MemberDAO;
import daily.game.dto.MemberDTO;

@Service
public class MemberService implements InterMemberService{
	
	@Autowired
	MemberDAO mdao;
	
	public int Join(MemberDTO mdto) {
		return mdao.Join(mdto);
	}

	@Override
	public ArrayList<MemberDTO> List() {
		
		return mdao.List();
	}

	@Override
	public MemberDTO Detail(MemberDTO mdto) {
		
		return mdao.Detail(mdto);
	}

	@Override
	public void Update(MemberDTO mdto) {
		mdao.Update(mdto);
	}

	@Override
	public int Delete(MemberDTO mdto) {
		
		
		return mdao.Delete(mdto);
		
	}

	@Override
	public MemberDTO Login(MemberDTO mdto) {
		
		return mdao.Login(mdto);
	}

	@Override
	public MemberDTO NDetail(MemberDTO mdto) {
		
		return mdao.NDetail(mdto);
	}

}
