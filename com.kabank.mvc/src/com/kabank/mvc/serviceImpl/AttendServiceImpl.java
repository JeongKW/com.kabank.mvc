package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.daoImpl.AttendDAOImpl;
import com.kabank.mvc.service.AttendService;

public class AttendServiceImpl implements AttendService{
	public static AttendService getInstance() { return new AttendServiceImpl(); }
	private AttendServiceImpl() { }
	@Override
	public ResultMap selectAttendById(Command cmd) {
		return AttendDAOImpl.getInstance().selectAttendById(cmd);
	}

	@Override
	public ResultMap createAttend(Command cmd) {
		AttendDAOImpl.getInstance().createAttend(cmd);
		return null;
	}
}
