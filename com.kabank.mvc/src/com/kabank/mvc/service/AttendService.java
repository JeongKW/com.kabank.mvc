package com.kabank.mvc.service;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;

public interface AttendService {
	public ResultMap createAttend(Command cmd);
	public ResultMap selectAttendById(Command cmd);
}
