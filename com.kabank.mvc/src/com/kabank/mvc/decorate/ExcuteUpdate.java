package com.kabank.mvc.decorate;

import com.kabank.mvc.command.ResultMap;

public class ExcuteUpdate extends QueryDecorator{
	public ExcuteUpdate(IQuery query) {
		super(query);
	}
	@Override
	public ResultMap excute() {
		return super.excute();
	}
}
