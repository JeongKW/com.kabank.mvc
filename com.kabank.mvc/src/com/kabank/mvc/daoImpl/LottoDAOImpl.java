package com.kabank.mvc.daoImpl;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.dao.LottoDAO;

public class LottoDAOImpl implements LottoDAO{
	public static LottoDAO getInstance() { return new LottoDAOImpl(); }
	private LottoDAOImpl() { }
	@Override
	public ResultMap selectLottoById(Command cmd) {
		return null;
	}
}
