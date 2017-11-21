package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;

/**
 * 修改员工密码控制器
 */
@WebServlet("/UpdateEmpPwdServlet")
public class UpdateEmpPwdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 输出流
		PrintWriter out = response.getWriter();
		
		//获得密码
		String empPwd = request.getParameter("newEmpPwd");
		
		//获得登录名
		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");
		
		//封装对象
		Emp emp = new Emp(empLoginName,empPwd);
		
		
		EmpService service = new EmpService();
		
		try {
			service.updateEmpPwd(emp);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
