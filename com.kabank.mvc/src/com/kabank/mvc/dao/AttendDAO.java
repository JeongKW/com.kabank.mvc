package com.kabank.mvc.dao;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;

public interface AttendDAO {
	public ResultMap createAttend(Command cmd);
	public ResultMap selectAttendById(Command cmd);
}
