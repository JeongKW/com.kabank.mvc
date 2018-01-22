package com.kabank.mvc.dao;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;

public interface BankDAO {
	public ResultMap createBank(Command cmd);
	public ResultMap createAccount(Command cmd);
	public ResultMap findAccount(Command cmd);
}
