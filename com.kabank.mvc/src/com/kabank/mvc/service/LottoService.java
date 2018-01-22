package com.kabank.mvc.service;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;

public interface LottoService {
	public ResultMap selectLottoById(Command cmd);
}
