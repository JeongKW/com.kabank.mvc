package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.daoImpl.LottoDAOImpl;
import com.kabank.mvc.service.LottoService;

public class LottoServiceImpl implements LottoService{
	public static LottoService getInstance() { return new LottoServiceImpl(); }
	private LottoServiceImpl() { }
	@Override
	public ResultMap selectLottoById(Command cmd) {
		return LottoDAOImpl.getInstance().selectLottoById(cmd);
	}
}
