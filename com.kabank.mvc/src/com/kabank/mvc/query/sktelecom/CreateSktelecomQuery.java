package com.kabank.mvc.query.sktelecom;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.enums.DDL;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class CreateSktelecomQuery implements IQuery{
	PreparedStatement pstmt;
	public CreateSktelecomQuery() {
		try {
			pstmt = DatabaseFactory.create(Vendor.ORACLE).getConnection().prepareStatement(
						DDL.CREATE + " " + DDL.TABLE + " "
						+ TnameEnum.MOBILE + "("
						+ "customer_num number primary key,"
						+ "phone VARCHAR2(20) not null,"
						+ "opendate date default(sysdate),"
						+ "telecom VARCHAR2(20) not null,"
						+ "id VARCHAR2(20),"
						+ DDL.FOREIGN + " " + DDL.KEY + "(id) "
						+ DDL.REFERENCES + " " + TnameEnum.MEMBER
						+ "(id) ON DELETE CASCADE)");
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
