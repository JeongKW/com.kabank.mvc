package com.kabank.mvc.daoImpl;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.dao.SktelecomDAO;
import com.kabank.mvc.decorate.ExcuteQuery;
import com.kabank.mvc.decorate.ExcuteUpdate;
import com.kabank.mvc.query.sktelecom.CreateSktelecomQuery;
import com.kabank.mvc.query.sktelecom.FindSktelecomByIdQuery;
import com.kabank.mvc.query.sktelecom.InsertSktelecomQuery;

public class SktelecomDAOImpl implements SktelecomDAO{
	public static SktelecomDAO getInstance() { return new SktelecomDAOImpl(); }
	private SktelecomDAOImpl() { }
	@Override
	public ResultMap createSktelecom(Command cmd) {
		new ExcuteUpdate(new CreateSktelecomQuery()).excute();
		return null;
	}
	@Override
	public ResultMap insertSktelecom(Command cmd) {
		System.out.println("----Skt-D : Insert In----");
		new ExcuteUpdate(new InsertSktelecomQuery()).excute();
		System.out.println("----Skt-D : Insert Out----");
		return null;
	}
	@Override
	public ResultMap findSktelecomById(Command cmd) {
		return (ResultMap) new ExcuteQuery(new FindSktelecomByIdQuery(cmd)).excute();
	}
	
	
}
