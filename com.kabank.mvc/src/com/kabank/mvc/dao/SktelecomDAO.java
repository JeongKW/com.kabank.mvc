package com.kabank.mvc.dao;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;

public interface SktelecomDAO {
	public ResultMap createSktelecom(Command cmd);
	public ResultMap insertSktelecom(Command cmd);
	public ResultMap findSktelecomById(Command cmd);
}
