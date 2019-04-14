package com.test.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginOut
 */
@WebServlet("/LoginOut")
public class LoginOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException
    	  {
    	    response.setContentType("text/html;charset=UTF-8");
    	    request.setCharacterEncoding("UTF-8");
    	  }

    	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException
    	  {
    	    response.setContentType("text/html;charset=UTF-8");
    	    request.setCharacterEncoding("UTF-8");
    	    String msg = "{";
    	    if (request.getSession().getAttribute("username") == null) {
    	      msg = msg + "\"status\":4006,\"message\":\"注销失败，你还未登录\"}";
    	      response.getWriter().append(msg);
    	    } else {
    	      request.getSession().invalidate();
    	      msg = msg + "\"status\":200,\"message\":\"注销成功\"}";
    	      response.getWriter().append(msg);
    	    }
    	  }
    	}