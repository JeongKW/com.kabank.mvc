package com.kabank.mvc.service;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;

public interface SktelecomService {
	public ResultMap createSktelecom(Command cmd);
	public ResultMap insertSktelecom(Command cmd);
	public ResultMap findSktelecomById(Command cmd);
}
