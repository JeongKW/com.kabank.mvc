package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.ChangeCommand;
import com.kabank.mvc.command.DeleteCommand;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.InsertCommand;
import com.kabank.mvc.command.LoginCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.domain.AttendBean;
import com.kabank.mvc.domain.FoodBean;
import com.kabank.mvc.domain.LottoBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.domain.PhoneBean;
import com.kabank.mvc.serviceImpl.AttendServiceImpl;
import com.kabank.mvc.serviceImpl.BankServiceImpl;
import com.kabank.mvc.serviceImpl.FoodServiceImpl;
import com.kabank.mvc.serviceImpl.LottoServiceImpl;
import com.kabank.mvc.serviceImpl.MemberServiceImpl;
import com.kabank.mvc.serviceImpl.SktelecomServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet({"/user.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		new InitCommand(request).excute();
		switch (InitCommand.cmd.getAction()) {
			case MOVE:
				System.out.println("----Member-C : Move In----");
				new MoveCommand(request).excute();
				System.out.println("DEST IS " + InitCommand.cmd.getView());
				System.out.println("----Member-C : Move Out----");
				DispatcherServlet.send(request, response);
				break;
			case ADD:
				System.out.println("----Member-C : Add In----");
				System.out.println("----Member-C : Add Out----");
				DispatcherServlet.send(request, response);
				break;
			case LOGIN:
				System.out.println("----Member-C : Login In----");
				login(request, session);
				DispatcherServlet.send(request, response);
				System.out.println("----Member-C : Login Out----");
				break;
			case JOIN:
				System.out.println("----Member-C : Add In----");
				new InsertCommand(request).excute();
				if(InitCommand.cmd.getData().split("/")[1].equals(InitCommand.cmd.getData().split("#")[1])) {
					MemberServiceImpl.getInstance().insertMember(InitCommand.cmd);
					InitCommand.cmd.setDir("user");
					InitCommand.cmd.setPage("login");
				} else {
					InitCommand.cmd.setDir("user");
					InitCommand.cmd.setPage("join");
				}
				new MoveCommand(request).excute();
				System.out.println("----Member-C : Add Out----");
				DispatcherServlet.send(request, response);
				break;
			case CHANGE:
				System.out.println("----Member-C : Change In----");
				update(request, session);
				System.out.println("----Member-C : Change Out----");
				DispatcherServlet.send(request, response);
				break;
			case DELETE:
				System.out.println("----Member-C : Delete In----");
				new DeleteCommand(request).excute();
				String[] deleteInfo = InitCommand.cmd.getData().split("/");
				if(deleteInfo[0].equals(deleteInfo[1])) {
					MemberServiceImpl.getInstance().deleteMember(InitCommand.cmd);
					InitCommand.cmd.setDir("user");
					InitCommand.cmd.setPage("login");
					session.invalidate();
				} else {
					InitCommand.cmd.setDir("user");
					InitCommand.cmd.setPage("deletemember");
				}
				new MoveCommand(request).excute();
				System.out.println("----Member-C : Delete Out----");
				DispatcherServlet.send(request, response);
				break;
			case MYPAGE:
				mypage(request, (MemberBean)session.getAttribute("user"));
				break;
			case LOGOUT:
				
				break;
			default: break;
		}
	}

	private void update(HttpServletRequest request, HttpSession session) {
		new ChangeCommand(request).excute();
		String[] info = InitCommand.cmd.getData().split("/");
		if(info[0].equals(info[1])) {
			MemberServiceImpl.getInstance().updateMember(InitCommand.cmd);
			MemberBean m = (MemberBean) session.getAttribute("user");
			m.setPw(info[0]);
			session.setAttribute("user", m);
			InitCommand.cmd.setDir("user");
			InitCommand.cmd.setPage("mypage");
		} else {
			InitCommand.cmd.setDir("user");
			InitCommand.cmd.setPage("changepw");
		}
		new MoveCommand(request).excute();
	}

	private void login(HttpServletRequest request, HttpSession session) {
		new LoginCommand(request).excute();
//		MemberBean member = MemberServiceImpl.getInstance().login(InitCommand.cmd);
		MemberBean member = new MemberBean();
		if(member == null) {
			InitCommand.cmd.setDir("user");
			InitCommand.cmd.setPage("login");
		} else {
			mypage(request, member);
			session.setAttribute("user", member);
			InitCommand.cmd.setDir("user");
			InitCommand.cmd.setPage("mypage");
		}
		new MoveCommand(request).excute();
	}

	private void mypage(HttpServletRequest request, MemberBean member) {
//		member.setAccount(BankServiceImpl.getInstance().findAccount(InitCommand.cmd));
//		member.setPhone(SktelecomServiceImpl.getInstance().findSktelecomById(InitCommand.cmd));
//		member.setAttend(AttendServiceImpl.getInstance().selectAttendById(InitCommand.cmd));
//		member.setLotto(LottoServiceImpl.getInstance().selectLottoById(InitCommand.cmd));
//		member.setFood(FoodServiceImpl.getInstance().selectFoodById(InitCommand.cmd));
//		if(member.getAccount() == null) {	
//			AccountBean aco = new AccountBean();
//			aco.setAccountNum("계좌없음");
//			member.setAccount(aco);
//		}
//		if(member.getPhone() == null) {
//			PhoneBean phone = new PhoneBean();
//			phone.setPhoneNumber("번호없음");
//			member.setPhone(phone);
//		}
//		if(member.getAttend() == null) {
//			AttendBean attend = new AttendBean();
//			attend.setStatus("출석없음");
//			member.setAttend(attend);
//		}
//		if(member.getLotto() == null) {
//			LottoBean lotto = new LottoBean();
//			lotto.setLottoNum("번호없음");
//			member.setLotto(lotto);
//		}
//		if(member.getFood() == null) {
//			FoodBean food = new FoodBean();
//			food.setMenu("먹은적없음");
//			member.setFood(food);
//		}
	}
}
