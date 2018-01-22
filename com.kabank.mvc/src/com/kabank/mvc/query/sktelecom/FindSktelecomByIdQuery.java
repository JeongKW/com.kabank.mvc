package com.kabank.mvc.query.sktelecom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.PhoneBean;
import com.kabank.mvc.enums.DmlEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class FindSktelecomByIdQuery implements IQuery{
	PreparedStatement pstmt;
	public FindSktelecomByIdQuery(Command cmd) {
		try {
			pstmt = DatabaseFactory.create(Vendor.ORACLE).getConnection().prepareStatement(DmlEnum.SELECT_PHONE_ID.toString());
			pstmt.setString(1, cmd.getData());
			InitCommand.cmd.getSql();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ResultMap excute() {
		PhoneBean phone = null;
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				phone = new PhoneBean();
				phone.setCustomerNum(rs.getString("customer_num"));
				phone.setOpendate((rs.getString("opendate")));
				phone.setPhoneNumber((rs.getString("phone")));
				phone.setTelecom(rs.getString("telecom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
