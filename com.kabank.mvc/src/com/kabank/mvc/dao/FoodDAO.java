package com.kabank.mvc.dao;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;

public interface FoodDAO {
	public ResultMap selectFoodById(Command cmd);
}
