package com.kabank.mvc.service;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;

public interface AdminService {
	public ResultMap createTable(Command cmd);
}
