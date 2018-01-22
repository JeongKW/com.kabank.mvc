package com.kabank.mvc.dao;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;

public interface MemberDAO {
	public ResultMap selectMembers(Command cmd);
	public ResultMap createMember(Command cmd);
	public ResultMap insertMember(Command cmd);
	public ResultMap selectMemberById(Command cmd);
	public ResultMap login(Command cmd);
	public ResultMap deleteMember(Command cmd);
	public ResultMap updateMember(Command cmd);
}
