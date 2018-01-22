package com.kabank.mvc.decorate;

import com.kabank.mvc.command.ResultMap;

public class ExcuteQuery extends QueryDecorator{
	public ExcuteQuery(IQuery query) {
		super(query);
	}
	@Override
	public ResultMap excute() {
		return super.excute();
	}
}
