package com.kabank.mvc.query.sktelecom;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class InsertSktelecomQuery implements IQuery{
	PreparedStatement pstmt;
	public InsertSktelecomQuery() {
		try {
			pstmt = DatabaseFactory.create(Vendor.ORACLE).getConnection().prepareStatement(InitCommand.cmd.getSql());
			String[] arr = InitCommand.cmd.getData().split("/");
			for(int i = 0; i < arr.length; i++) {
				pstmt.setString(i+1, arr[i]);
			}
			InitCommand.cmd.getSql();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ResultMap excute() {
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
