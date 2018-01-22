package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService{
	public static MemberServiceImpl getInstance() { return new MemberServiceImpl(); }

	private MemberServiceImpl() { }
	@Override
	public ResultMap findMemberById(Command cmd) {
		return MemberDAOImpl.getInstance().selectMemberById(cmd);
	}
	
	@Override
	public ResultMap insertMember(Command cmd) {
		MemberDAOImpl.getInstance().insertMember(cmd);
		return null;
	}

	@Override
	public ResultMap login(Command cmd) {
		return MemberDAOImpl.getInstance().login(cmd);
	}
	
	@Override
	public ResultMap deleteMember(Command cmd) {
		MemberDAOImpl.getInstance().deleteMember(cmd);
		return null;
	}
	
	@Override
	public ResultMap updateMember(Command cmd) {
		MemberDAOImpl.getInstance().updateMember(cmd);
		return null;
	}
	
	
	
}
