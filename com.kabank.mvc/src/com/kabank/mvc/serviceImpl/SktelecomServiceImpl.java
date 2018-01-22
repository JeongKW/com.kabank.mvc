package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.daoImpl.SktelecomDAOImpl;
import com.kabank.mvc.service.SktelecomService;

public class SktelecomServiceImpl implements SktelecomService{
	public static SktelecomService getInstance() { return new SktelecomServiceImpl(); }
	private SktelecomServiceImpl() { }
	@Override
	public ResultMap createSktelecom(Command cmd) {
		SktelecomDAOImpl.getInstance().createSktelecom(cmd);
		return null;
	}
	@Override
	public ResultMap insertSktelecom(Command cmd) {
		SktelecomDAOImpl.getInstance().insertSktelecom(cmd);
		return null;
	}
	@Override
	public ResultMap findSktelecomById(Command cmd) {
		return SktelecomDAOImpl.getInstance().findSktelecomById(cmd);
	}
	
}
