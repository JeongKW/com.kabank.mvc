package com.kabank.mvc.service;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;

public interface MemberService {
	public ResultMap insertMember(Command cmd);
	public ResultMap findMemberById(Command cmd);
	public ResultMap login(Command cmd);
	public ResultMap updateMember(Command cmd);
	public ResultMap deleteMember(Command cmd);
}
