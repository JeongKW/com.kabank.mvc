package com.kabank.mvc.service;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;

public interface FoodService {
	public ResultMap selectFoodById(Command cmd);
}
