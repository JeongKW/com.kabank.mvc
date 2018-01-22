package com.kabank.mvc.decorate;

import com.kabank.mvc.command.ResultMap;

public abstract class QueryDecorator implements IQuery{
	protected IQuery query;
	public QueryDecorator(IQuery query) {
		this.query = query;
	}
	@Override
	public ResultMap excute() {
		return query.excute();
	}
}
