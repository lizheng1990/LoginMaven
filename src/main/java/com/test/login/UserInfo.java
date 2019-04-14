package com.test.login;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.ConnectMysql;
import com.test.common.UseMysql;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String information = "{";
		String user = null;
		if (request.getSession().getAttribute("username") != null) {
			user = request.getSession().getAttribute("username").toString();
			ConnectMysql connSql = new ConnectMysql();
			UseMysql mySql = new UseMysql(connSql.conn);
			Map<String, String> userinfo = mySql.getUserInfo(user);
			for (String key : userinfo.keySet()) {
				information = information + "\"" + key + "\":\"" + (String) userinfo.get(key) + "\",";
			}
			information = information + "\"status\":200,\"message\":\"获取成功！\"}";
		} else {
			information = information + "\"status\":4006,\"message\":\"获取失败，你还未登录\"}";
		}
		response.getWriter().append(information);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}