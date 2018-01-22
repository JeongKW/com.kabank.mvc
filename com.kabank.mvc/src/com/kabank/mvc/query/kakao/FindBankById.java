package com.kabank.mvc.query.kakao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.enums.BankProps;
import com.kabank.mvc.enums.DML;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;

public class FindBankById implements IQuery{
	PreparedStatement pstmt;
	public FindBankById(Command cmd) {
		try {
			pstmt = DatabaseFactory.create(Vendor.ORACLE).getConnection().prepareStatement(
						DML.SELECT + " "
						+ BankProps.ACCOUNT_NUM + "," + BankProps.CUSTOMER_NUM + "," + BankProps.MONEY + " "
						+ DML.FROM + " "
						+ TnameEnum.BANK + " "
						+ DML.WHERE + " id = ?");
			pstmt.setString(1, cmd.getData());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ResultMap excute() {
		AccountBean account = null;
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				account = new AccountBean();
				account.setAccountNum(rs.getString("account_num"));
				account.setCustomNum(rs.getString("customer_num"));
				account.setMoney(rs.getString("money"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
