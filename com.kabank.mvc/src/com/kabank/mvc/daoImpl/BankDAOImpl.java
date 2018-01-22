package com.kabank.mvc.daoImpl;

import java.sql.SQLException;
import java.sql.Statement;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.dao.BankDAO;
import com.kabank.mvc.decorate.ExcuteQuery;
import com.kabank.mvc.enums.DdlEnum;
import com.kabank.mvc.enums.DmlEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.query.kakao.FindBankById;

public class BankDAOImpl implements BankDAO{
	public static BankDAO getInstance() { return new BankDAOImpl();	}
	private BankDAOImpl() { }

	@Override
	public ResultMap createBank(Command cmd) {
		try {
			Statement stmt = DatabaseFactory.create(Vendor.ORACLE).getConnection().createStatement();
			stmt.executeUpdate(DmlEnum.BANK_INCRETMENT.toString());
			stmt.executeUpdate(DdlEnum.CREATE_TABLE_BANK.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ResultMap createAccount(Command cmd) {
		try {
			DatabaseFactory.create(Vendor.ORACLE).getConnection().createStatement().executeUpdate(InitCommand.cmd.getSql());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ResultMap findAccount(Command cmd) {
		return (ResultMap) new ExcuteQuery(new FindBankById(cmd)).excute();
	}
}
