package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.daoImpl.FoodDAOImpl;
import com.kabank.mvc.service.FoodService;

public class FoodServiceImpl implements FoodService{
	public static FoodService getInstance() { return new FoodServiceImpl();	}
	private FoodServiceImpl() {	}
	@Override
	public ResultMap selectFoodById(Command cmd) {
		return FoodDAOImpl.getInstance().selectFoodById(cmd);
	}
}
