package com.kabank.mvc.daoImpl;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.dao.FoodDAO;

public class FoodDAOImpl implements FoodDAO{
	public static FoodDAO getInstance() { return new FoodDAOImpl(); }
	private FoodDAOImpl() {	}
	@Override
	public ResultMap selectFoodById(Command cmd) {
		return null;
	}
}
