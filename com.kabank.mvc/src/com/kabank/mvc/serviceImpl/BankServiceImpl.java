package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.daoImpl.BankDAOImpl;
import com.kabank.mvc.service.BankService;

public class BankServiceImpl implements BankService{
	public static BankService getInstance() { return new BankServiceImpl(); }
	private BankServiceImpl() { }
	@Override
	public ResultMap createBank(Command cmd) { 
		BankDAOImpl.getInstance().createBank(cmd);
		return null;
	}
	@Override
	public ResultMap createAccount(Command cmd) {
		BankDAOImpl.getInstance().createAccount(cmd);
		return null;
	}
	@Override
	public ResultMap findAccount(Command cmd) {
		BankDAOImpl.getInstance().findAccount(cmd);
		return null;
	}
}
