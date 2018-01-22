package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.daoImpl.AttendDAOImpl;
import com.kabank.mvc.daoImpl.BankDAOImpl;
import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.service.AdminService;

public class AdminServiceImpl implements AdminService{
	public static AdminService getInstance() { return new AdminServiceImpl(); }
	private AdminServiceImpl() {	}
	@Override
	public ResultMap createTable(Command cmd) {
		switch(cmd.getData()) {
		case "member":
			MemberDAOImpl.getInstance().createMember(cmd);
			break;
		case "attend":
			AttendDAOImpl.getInstance().createAttend(cmd);
			break;
		case "bank":
			BankDAOImpl.getInstance().createBank(cmd);
			break;
		case "sktelecom":
			SktelecomServiceImpl.getInstance().createSktelecom(cmd);
			break;
		}
		return null;
	}
}
