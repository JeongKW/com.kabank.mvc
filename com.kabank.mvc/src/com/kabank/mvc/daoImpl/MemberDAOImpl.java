package com.kabank.mvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.ResultMap;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.decorate.ExcuteQuery;
import com.kabank.mvc.decorate.ExcuteUpdate;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DdlEnum;
import com.kabank.mvc.enums.DmlEnum;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DatabaseFactory;
import com.kabank.mvc.factory.SqlFactory;
import com.kabank.mvc.query.member.DeleteMemberQuery;
import com.kabank.mvc.query.member.InsertMemberQuery;
import com.kabank.mvc.query.member.LoginQuery;

public class MemberDAOImpl implements MemberDAO{
	public static MemberDAO getInstance() { return new MemberDAOImpl(); }
	
	private MemberDAOImpl() { }
	@Override
	public ResultMap selectMembers(Command cmd) {
		List<MemberBean> list = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.create(Vendor.ORACLE)
					.getConnection()
					.createStatement()
					.executeQuery(DmlEnum.ALLTABLE.toString());
			while(rs.next()) {
				MemberBean res = new MemberBean();
				res.setId(rs.getString(MemberEnum.ID.name()));
				res.setPw(rs.getString(MemberEnum.PW.name()));
				res.setName(rs.getString(MemberEnum.NAME.name()));
				res.setSsn(rs.getString(MemberEnum.SSN.name()));
				res.setEmail(rs.getString(MemberEnum.EMAIL.name()));
				res.setProfile(rs.getString(MemberEnum.PROFILE.name()));
				res.setAddr(rs.getString(MemberEnum.ADDR.name()));
				list.add(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMap createMember(Command cmd) {
		try {
			DatabaseFactory.create(Vendor.ORACLE).getConnection()
			.createStatement().executeUpdate(DdlEnum.CREATE_TABLE_MEMBER.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMap insertMember(Command cmd) {
		new ExcuteUpdate(new InsertMemberQuery()).excute();
		return null;
	}

	@Override
	public ResultMap selectMemberById(Command cmd) {
		MemberBean res = null;
		try {
			ResultSet rs = DatabaseFactory.create(Vendor.ORACLE).getConnection()
			.createStatement()
			.executeQuery(String.format(SqlFactory.create(7, DmlEnum.SELECT.toString() + TnameEnum.MEMBER.name(), DmlEnum.MEMBER_LOGIN.toString())));
			while(rs.next()) {
				res = new MemberBean();
				res.setId(rs.getString(MemberEnum.ID.name()));
				res.setPw(rs.getString(MemberEnum.PW.name()));
				res.setName(rs.getString(MemberEnum.NAME.name()));
				res.setSsn(rs.getString(MemberEnum.SSN.name()));
				res.setEmail(rs.getString(MemberEnum.EMAIL.name()));
				res.setProfile(rs.getString(MemberEnum.PROFILE.name()));
				res.setAddr(rs.getString(MemberEnum.ADDR.name()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMap login(Command cmd) {
		return (ResultMap) new ExcuteQuery(new LoginQuery()).excute();
	}

	@Override
	public ResultMap updateMember(Command cmd) {
		System.out.println("----Member-D : Update In----");
		try {
			DatabaseFactory.create(Vendor.ORACLE).getConnection()
			.createStatement().executeUpdate(InitCommand.cmd.getSql());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("----Member-D : Update Out----");
		return null;
	}

	@Override
	public ResultMap deleteMember(Command cmd) {
		System.out.println("----Member-D : Delete In----");
		new ExcuteUpdate(new DeleteMemberQuery()).excute();
		System.out.println("----Member-D : Delete Out----");
		return null;
	}

}
