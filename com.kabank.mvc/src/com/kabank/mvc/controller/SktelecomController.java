package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.InsertCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.serviceImpl.SktelecomServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet("/skt.do")
public class SktelecomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		new InitCommand(request).excute();
		switch(InitCommand.cmd.getAction()) {
		case MOVE:
			System.out.println("----Sktelecom-C : Move In----");
			new MoveCommand(request).excute();
			System.out.println("----Sktelecom-C : Move Out----");
			DispatcherServlet.send(request, response);
			break;
		case CREATE:
			System.out.println("----Sktelecom-C : Create In----");
			new InsertCommand(request).excute();
			MemberBean member = (MemberBean) session.getAttribute("user");
			InitCommand.cmd.setData(InitCommand.cmd.getData() + "/" + member.getId());
			SktelecomServiceImpl.getInstance().insertSktelecom(InitCommand.cmd);
//			member.setPhone(SktelecomServiceImpl.getInstance().findSktelecomById(InitCommand.cmd));
			session.setAttribute("user", member);
			new MoveCommand(request).excute();
			System.out.println("----Sktelecom-C : Create In----");
			DispatcherServlet.send(request, response);
			break;
		default: break;
		}
	}
}
