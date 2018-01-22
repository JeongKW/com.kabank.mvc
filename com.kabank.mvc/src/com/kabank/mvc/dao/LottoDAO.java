package com.kabank.mvc.dao;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;

public interface LottoDAO {
	public ResultMap selectLottoById(Command cmd);
}
