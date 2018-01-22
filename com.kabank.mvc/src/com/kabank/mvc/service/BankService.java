package com.kabank.mvc.service;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;

public interface BankService {
	public ResultMap createBank(Command cmd);
	public ResultMap createAccount(Command cmd);
	public ResultMap findAccount(Command cmd);
}
