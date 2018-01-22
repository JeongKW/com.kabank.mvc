package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.enums.PathEnum;
import com.kabank.mvc.serviceImpl.AdminServiceImpl;

@WebServlet({"/admin.do"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dest = "";
		String dir = "";
		new InitCommand(request).excute();
		switch(InitCommand.cmd.getData()) {
			case "move":
				dest = "main";
				dir = "admin";
				break;
			case "create_table":
				AdminServiceImpl.getInstance().createTable(InitCommand.cmd);
				dest = "main";
				dir = "admin";
				break;
		}
		request.getRequestDispatcher(
				PathEnum.VIEW.getValue() + dir + PathEnum.SEPARATOR.getValue() + dest + PathEnum.EXTENSION.getValue()).forward(request, response);
	}
}
